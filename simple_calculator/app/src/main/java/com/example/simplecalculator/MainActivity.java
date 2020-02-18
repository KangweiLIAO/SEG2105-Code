package com.example.simplecalculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private enum Operator {none, add, minus, multiply, divide}
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;
    private boolean dotInput = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnClearClick(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        TextView aText = (TextView)findViewById(R.id.algebraEdit);
        optr = Operator.none;
        eText.setText("0");
        aText.setText("");
    }

    public void btnAddClick(View view){
        if (optr == Operator.none){
            optr = Operator.add;
            TextView eText = (TextView)findViewById(R.id.resultEdit);
            TextView aText = (TextView)findViewById(R.id.algebraEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText("");
            aText.setText(data1 + "+");
        }
    }

    public void btnMinusClick(View view){
        if (optr == Operator.none) {
            optr = Operator.minus;
            TextView eText = (TextView) findViewById(R.id.resultEdit);
            TextView aText = (TextView) findViewById(R.id.algebraEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText("");
            aText.setText(data1 + "-");
        }
    }

    public void btnMultiplyClick(View view){
        if (optr == Operator.none) {
            optr = Operator.multiply;
            TextView eText = (TextView) findViewById(R.id.resultEdit);
            TextView aText = (TextView) findViewById(R.id.algebraEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText("");
            aText.setText(data1 + "×");
        }
    }

    public void btnDivideClick(View view){
        if (optr == Operator.none) {
            optr = Operator.divide;
            TextView eText = (TextView) findViewById(R.id.resultEdit);
            TextView aText = (TextView) findViewById(R.id.algebraEdit);
            data1 = Double.parseDouble(eText.getText().toString());
            eText.setText("");
            aText.setText(data1 + "÷");
        }
    }

    public void btnDeleteClick(View view){
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        if (eText.getText().length() <= 1){
            eText.setText("0");
        }else if (eText.getText().length() > 1){
            eText.setText(eText.getText().subSequence(0, eText.getText().length()-1));
        }
    }

    public void btnResultClick(View view){
        if (optr != Operator.none){
            TextView eText = (TextView)findViewById(R.id.resultEdit);
            TextView aText = (TextView)findViewById(R.id.algebraEdit);
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if (optr == Operator.add){
                result = data1 + data2;
                aText.setText(data1 + "+" + data2 + "=");
            }else if (optr == Operator.minus){
                result = data1 - data2;
                aText.setText(data1 + "-" + data2 + "=");
            }else if (optr == Operator.multiply){
                result = data1 * data2;
                aText.setText(data1 + "×" + data2 + "=");
            }else if (optr == Operator.divide){
                result = data1 / data2;
                aText.setText(data1 + "÷" + data2 + "=");
            }
            optr = Operator.none;
            data1 = result;
            dotInput = false;

            // print double if value is not x.0
            if ((result-(int)result) != 0){
                eText.setText(String.valueOf(result));
            }else{
                eText.setText(String.valueOf((int)result));
            }
        }
    }

    public void btnDotClick(View view) {
        TextView eText = (TextView) findViewById(R.id.resultEdit);
        int count = 0;
        dotInput = true;
        for (int i=0; i<eText.getText().length(); i++){
            if (eText.getText().charAt(i) == '.')
                count++;
        }
        if (!(count > 0))
            eText.setText(eText.getText() + ".");
    }

    public void btn00Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("0");
        }else {
            eText.setText(eText.getText() + "0");
        }
    }

    public void btn01Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("1");
        }else {
            eText.setText(eText.getText() + "1");
        }
    }

    public void btn02Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("2");
        }else {
            eText.setText(eText.getText() + "2");
        }
    }

    public void btn03Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("3");
        }else {
            eText.setText(eText.getText() + "3");
        }
    }

    public void btn04Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("4");
        }else {
            eText.setText(eText.getText() + "4");
        }
    }

    public void btn05Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("5");
        }else {
            eText.setText(eText.getText() + "5");
        }
    }

    public void btn06Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("6");
        }else {
            eText.setText(eText.getText() + "6");
        }
    }

    public void btn07Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("7");
        }else {
            eText.setText(eText.getText() + "7");
        }
    }

    public void btn08Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("8");
        }else {
            eText.setText(eText.getText() + "8");
        }
    }

    public void btn09Click(View view){
        TextView eText = (TextView)findViewById(R.id.resultEdit);
        if (optr == Operator.none
                && eText.getText().charAt(0) == '0'
                && dotInput != true){
            eText.setText("9");
        }else {
            eText.setText(eText.getText() + "9");
        }
    }
}
