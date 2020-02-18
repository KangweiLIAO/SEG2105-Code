package design2;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPArrayTest
{

	//Class methods *****************************************************

	/**
	 * This method is responsible for the creation of the PointCP
	 * object.  This can be done in two ways; the first, by using the
	 * command line and running the program using <code> java 
	 * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
	 * </code> and the second by getting the program to prompt the user.
	 * If the user does not enter a valid sequence at the command line,
	 * the program will prompte him or her.
	 *
	 * @param args[0] The value of X or RHO.
	 * @param args[1] The value of Y or THETA.
	 */
	public static void main(String[] args)
	{
		System.out.println("ArrayList test for Cartesian-Polar Coordinates Conversion Program\n");
		arrayListTest(12000000);
	}

	/**
	 * This method will create random instance and run each method thousands of times.
	 *
	 * @param  sampleSize Sample size
	 * @param  iterations How many times of iterations for each methods
	 */
	private static void arrayListTest(int sampleSize)
	{
		System.out.println("Start Testing with " + sampleSize + " samples...");
		System.out.println("-----------------------------------------");
		Random rand = new Random();
		long[] times = new long[7];
		long start, end, totalStart, totalEnd;
		
		PointCPD2[] samplesOrdinary = new PointCPD2[sampleSize];
		ArrayList<PointCPD2> samplesArray = new ArrayList<PointCPD2>();
		LinkedList<PointCPD2> samplesLinked = new LinkedList<PointCPD2>();

		totalStart = System.currentTimeMillis();
		// Test ArrayList
		start = System.currentTimeMillis();
		for(int i = 0; i<sampleSize; i++) {
			double randD1 = rand.nextDouble()*9; // Random X from [0, 9]
			double randD2 = rand.nextDouble()*9; // Random Y from [0, 9]
			samplesArray.add(new PointCPD2(randD1, randD2));
		}
		end = System.currentTimeMillis();
		times[0] = end-start;
		
		// Test LinkedList
		start = System.currentTimeMillis();
		for(int i = 0; i<sampleSize; i++) {
			double randD1 = rand.nextDouble()*9; // Random X from [0, 9]
			double randD2 = rand.nextDouble()*9; // Random Y from [0, 9]
			samplesLinked.add(new PointCPD2(randD1, randD2));
		}
		end = System.currentTimeMillis();
		times[1] = end-start;
		
		// Test ordinary list
		start = System.currentTimeMillis();
		for(int i = 0; i<sampleSize; i++) {
			double randD1 = rand.nextDouble()*9; // Random X from [0, 9]
			double randD2 = rand.nextDouble()*9; // Random Y from [0, 9]
			samplesOrdinary[i] = new PointCPD2(randD1, randD2);
		}
		end = System.currentTimeMillis();
		times[2] = end-start;
		
		Iterator<PointCPD2> iteratorA = samplesArray.iterator();
		Iterator<PointCPD2> iteratorL = samplesLinked.iterator();
		//Test ArrayList Iterator
		start = System.currentTimeMillis();
		while(iteratorA.hasNext()) {
			iteratorA.next();
		}
		end = System.currentTimeMillis();
		times[3] = end-start;

		//Test ArrayList Iterator
		start = System.currentTimeMillis();
		while(iteratorL.hasNext()) {
			iteratorL.next();
		}
		end = System.currentTimeMillis();
		times[4] = end-start;

		//Test ordinary array sum
		start = System.currentTimeMillis();
		for(int i=0; i<sampleSize; i++) {
			PointCPD2 a = samplesOrdinary[i];
		}
		end = System.currentTimeMillis();
		times[5] = end-start;

		totalEnd = System.currentTimeMillis(); // get total runtime for test
		times[6] = totalEnd - totalStart;

		showTestResult(times);
	}

	/**
	 * This method will show the information of the runtime test.
	 *
	 * @param  times Recieve runtime details
	 */
	private static void showTestResult(long[] times) {
		System.out.println("Total runtime for Array Test is "+times[6]+"ms: "
				+ "\n takes " + times[0] + "ms to add samples in ArrayList;"
				+ "\n takes " + times[1] + "ms to add samples in LinkedList;"
				+ "\n takes " + times[2] + "ms to add samples in ordinary array;"
				+ "\n takes " + times[3] + "ms to use iterator sum ArrayList;"
				+ "\n takes " + times[4] + "ms to use iterator sum LinkedList;"
				+ "\n takes " + times[5] + "ms to use for loop sum ordinary array.");
	}
}
