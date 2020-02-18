package com.example.seg2105lab5;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPrice;
    Button buttonAddProduct;
    ListView listViewProducts;
    DatabaseReference databaseProducts;

    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseProducts = FirebaseDatabase.getInstance().getReference("products");  // get an instance of connected FireBase
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        buttonAddProduct = (Button) findViewById(R.id.addButton);

        products = new ArrayList<>();

        //adding an onclicklistener to button
        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });

        listViewProducts.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = products.get(i);
                showUpdateDeleteDialog(product.getId(), product.getProductName());
                return true;
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                products.clear(); // clear previous product list

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Product product = postSnapshot.getValue(Product.class); // get product from db
                    products.add(product); // add products to array list
                }
                // create adapter & attach adapter to list view (?)
                ProductList productsAdapter = new ProductList(MainActivity.this, products);
                listViewProducts.setAdapter(productsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });
    }

    private void showUpdateDeleteDialog(final String productId, String productName) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.editTextName);
        final EditText editTextPrice  = (EditText) dialogView.findViewById(R.id.editTextPrice);
        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.buttonUpdateProduct);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.buttonDeleteProduct);

        dialogBuilder.setTitle(productName);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                double price = Double.parseDouble(String.valueOf(editTextPrice.getText().toString()));
                if (!TextUtils.isEmpty(name)) {
                    updateProduct(productId, name, price);
                    b.dismiss();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProduct(productId);
                b.dismiss();
            }
        });
    }

    private void updateProduct(String id, String name, double price) {
        // get a db reference of the product in db
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("products").child(id);
        // create a new product instance to replace the old one
        Product product = new Product(id, name, price);
        dR.setValue(product);

        Toast.makeText(this, "Product updated", Toast.LENGTH_LONG).show();
    }

    private void deleteProduct(String id) {
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("products").child(id);
        dR.removeValue();

        Toast.makeText(this, "Product deleted", Toast.LENGTH_LONG).show();
    }

    private void addProduct() {
        String name = editTextName.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){
            double price = Double.parseDouble(String.valueOf(editTextPrice.getText().toString()));
            String id = databaseProducts.push().getKey();   // get an unique id for new product
            Product product = new Product(id, name, price); // create a new Product instance
            databaseProducts.child(id).setValue(product);   // Save the product to database

            // set editTexts (in activity_main.xml) to blank (will not affect hint)
            editTextName.setText("");
            editTextPrice.setText("");

            Toast.makeText(this, "Product added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
        // Toast.makeText(this, "NOT IMPLEMENTED YET", Toast.LENGTH_LONG).show();
    }
}