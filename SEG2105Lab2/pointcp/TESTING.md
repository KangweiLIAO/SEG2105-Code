
# Your discussion about testing

This is where you should provide a description in
[GitHub Markdown](https://guides.github.com/features/mastering-markdown/)
that clearly describes:

* how you did the tests,
* sample outputs from running the tests
* the table and
* a discussion of the results.

## Design 2:
**Description:**
1. Get user input for the `type of points` and `coordinates`, and verify them.
* If user inputted `C` for the type, the coordinates for this Cartesian point will be converted & stored in to a Polar point.
2. Run the runtime test with indicated `samples size` & how many `iterations` will do for each method of PointCPD2.
3. Print the test result.

**Sample Output:**
[OUTPUT.md](/pointcp/OUTPUT.md)

**Table:**

| Design 2 Methods | Average(ms) | Maximum(ms) | Minimum(ms) |
| --- | --- | --- | --- |
| getX() | 13 | 16 | 2 |
| getY() | 13 | 1 | 0 |
| GetRho() | 0 | 1 | 0 |
| GetTheta() | 0 | 1 | 0 |
| convertStorageToCartesian() | 29 | 33 | 24 |
| convertStorageToPolar() | 0 | 7 | 0 |
| getDistance() | 31 | 51 | 26 |
| rotatePoint() | 87 | 98 | 67 |
| toString() | 148 | 202 | 134 |

**Discussion:**  
[E26.md](/pointcp/E26.md)  
[E28.md](/pointcp/E28.md)

## Design 3:
**Description:**
1. Get user input for the `type of points` and `coordinates`, and verify them.
* If user inputted `P` for the type, the coordinates for this Polar point will be converted & stored in to a Cartesian point.
2. Run the runtime test with indicated `samples size` & how many `iterations` will do for each method of PointCPD3.
3. Print the test result.

**Sample Output**
[OUTPUT.md](/pointcp/OUTPUT.md)

**Table**

| Design 3 Methods | Average(ms) | Maximum(ms) | Minimum(ms) |
| --- | --- | --- | --- |
| getX() | 0 | 8 | 0 |
| getY() | 0 | 6 | 0 |
| GetRho() | 0 | 7 | 0 |
| GetTheta() | 19 | 25 | 14 |
| convertStorageToCartesian() | 0 | 5 | 0 |
| convertStorageToPolar() | 20 | 43 | 14 |
| getDistance() | 0 | 9 | 0 |
| rotatePoint() | 44 | 84 | 35 |
| toString() | 161 | 276 | 142 |

**Discussion**
[E26.md](/pointcp/E26.md)  
[E29.md](/pointcp/E29.md)

## Design 6:
**Description:**
1. Get user input for the `type of points` and `coordinates`, and verify them.
* If user inputted `P` for the type, will generate a instance of Polar point. 
* If user inputted `C` for the type, will generate a instance of Cartesian point. 
* The runtime test will base on the type that was inputted.
2. Run the runtime test with indicated `samples size` & how many `iterations` will do for each method of PointCPD2/3.
3. Print the test result.

**Sample Output**
[OUTPUT.md](/pointcp/OUTPUT.md)

**Table**

| Design 6 PointCPD2 | Average(ms) | Maximum(ms) | Minimum(ms) |
| --- | --- | --- | --- |
| getX() | 15 | 55 | 1 |
| getY() | 15 | 38 | 1 |
| GetRho() | 0 | 1 | 0 |
| GetTheta() | 0 | 1 | 0 |
| convertStorageToCartesian() | 33 | 81 | 18 |
| convertStorageToPolar() | 0 | 4 | 0 |
| getDistance() | 32 | 77 | 22 |
| rotatePoint() | 98 | 194 | 70 |
| toString() | 158 | 318 | 127 |

| Design 6 PointCPD3 | Average(ms) | Maximum(ms) | Minimum(ms) |
| --- | --- | --- | --- |
| getX() | 0 | 7 | 0 |
| getY() | 0 | 6 | 0 |
| GetRho() | 0 | 1 | 0 |
| GetTheta() | 18 | 29 | 13 |
| convertStorageToCartesian() | 0 | 4 | 0 |
| convertStorageToPolar() | 18 | 31 | 13 |
| getDistance() | 0 | 6 | 0 |
| rotatePoint() | 41 | 90 | 34 |
| toString() | 154 | 267 | 136 |

**Discussion**
[E26.md](/pointcp/E26.md)  
[E30.md](/pointcp/E30.md)


