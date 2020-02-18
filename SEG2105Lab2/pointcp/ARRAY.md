
Commit your data about arrays here.

Use suitable tables and draw conclusions
from an analysis of the data. From your conclusions,
develop recommendations to designers.

## Part A
#### Array test for Design 2
```
ArrayList test for Cartesian-Polar Coordinates Conversion Program

Start Testing with 12000000 samples...
-----------------------------------------
Total runtime for Array Test is 19915ms: 
 takes 4059ms to add samples in ArrayList;
 takes 6107ms to add samples in LinkedList;
 takes 9627ms to add samples in ordinary array.
```


#### Array test for Design 3
```
ArrayList test for Cartesian-Polar Coordinates Conversion Program

Start Testing with 12000000 samples...
-----------------------------------------
Total runtime for Array Test is 20792ms: 
 takes 4286ms to add samples in ArrayList;
 takes 6040ms to add samples in LinkedList;
 takes 10319ms to add samples in ordinary array.
```

#### Array test for Design 6
```
ArrayList test for Cartesian-Polar Coordinates Conversion Program

Start Testing with 12000000 samples...
-----------------------------------------
Total runtime for Array Test is 21746ms: 
 takes 4708ms to add samples in ArrayList;
 takes 5965ms to add samples in LinkedList;
 takes 10926ms to add samples in ordinary array.

Start Testing with 12000000 samples...
-----------------------------------------
Total runtime for Array Test is 12988ms: 
 takes 1476ms to add samples in ArrayList;
 takes 5690ms to add samples in LinkedList;
 takes 5670ms to add samples in ordinary array.
```
| Structure | Speed for adding elements |
|---|---|
| ArrayList | Fastest |
| LinkedList | Faster than ordinary array |
| Ordinary array | Slowest |


## Part B

#### Array test for Design 2
```
ArrayList test for Cartesian-Polar Coordinates Conversion Program

Start Testing with 12000000 samples...
-----------------------------------------
Total runtime for Array Test is 21037ms: 
 takes 2559ms to add samples in ArrayList;
 takes 8440ms to add samples in LinkedList;
 takes 9918ms to add samples in ordinary array;
 takes 10ms to use iterator sum ArrayList;
 takes 104ms to use iterator sum LinkedList;
 takes 5ms to use for loop sum ordinary array.
```

#### Array test for Design 3
```
ArrayList test for Cartesian-Polar Coordinates Conversion Program

Start Testing with 12000000 samples...
-----------------------------------------
Total runtime for Array Test is 21037ms: 
 takes 2559ms to add samples in ArrayList;
 takes 8440ms to add samples in LinkedList;
 takes 9918ms to add samples in ordinary array;
 takes 10ms to use iterator sum ArrayList;
 takes 104ms to use iterator sum LinkedList;
 takes 5ms to use for loop sum ordinary array.
```

#### Array test for Design 6
```
ArrayList test for Cartesian-Polar Coordinates Conversion Program

Start Testing with 12000000 samples...
-----------------------------------------
Total runtime for Array Test is 19533ms: 
 takes 3824ms to add samples in ArrayList;
 takes 6099ms to add samples in LinkedList;
 takes 9462ms to add samples in ordinary array;
 takes 15ms to use iterator sum ArrayList;
 takes 127ms to use iterator sum LinkedList;
 takes 6ms to use for loop sum ordinary array.

Start Testing with 12000000 samples...
-----------------------------------------
Total runtime for Array Test is 12270ms: 
 takes 1285ms to add samples in ArrayList;
 takes 5625ms to add samples in LinkedList;
 takes 5242ms to add samples in ordinary array;
 takes 9ms to use iterator sum ArrayList;
 takes 102ms to use iterator sum LinkedList;
 takes 7ms to use for loop sum ordinary array.
```
| Structure | Speed for reading elements |
|---|---|
| ArrayList iterator | Faster than LinkedList |
| LinkedList iterator | Slowest |
| Ordinary array | Fastest |
