package design2;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.util.Random;

import design3.PointCPD3;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest
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
		char coordType = 'A'; //initialize type
		double[] coords = new double[2]; // double array to store coords
		PointCPD2 pPoint= new PointCPD2(coords[0], coords[1]); //initialize PointCPD2 instance

		System.out.println("Cartesian-Polar Coordinates Conversion Program");

		// Check if the user input coordinates from the command line
		// If he did, create the polar PointCP object from these arguments.
		// If he did not, prompt the user for them.
		try
		{
			pPoint = new PointCPD2(Double.valueOf(args[0]).doubleValue(), 
					Double.valueOf(args[1]).doubleValue());
		}
		catch(Exception e)
		{
			// If we arrive here, it is because either there were no
			// command line arguments, or they were invalid
			if(args.length != 0)
				System.out.println("Invalid arguments on command line");
			try
			{
				coordType = getInputs(coords);
				if(coordType == 'P') 
				{
					pPoint = new PointCPD2(coords[0], coords[1]);
				}else {
					PointCPD3 cPoint = new PointCPD3(coords[0], coords[1]);
					pPoint = cPoint.convertStorageToPolar();
				}
			}
			catch(IOException ex)
			{
				System.out.println("Error getting input. Ending program.");
				return;
			}
		}
		System.out.println("\nYou entered:\n" + pPoint);
		pPoint.convertStorageToCartesian();
		System.out.println("Convert to Cartesian:\n" + "[" + pPoint.getX() +"," + pPoint.getY() + "]\n");
		pPoint.convertStorageToPolar();
		System.out.println("After asking to store as Polar:\n" + pPoint);
		runtimeTest(30,200000);
	}

	/**
	 * This method obtains input from the user and verifies that
	 * it is valid.  When the input is valid, it returns a char type
	 * representing the coordType.
	 *
	 * @param  coords Receive the coordType
	 * @return The coord type inputed by the user.
	 * @throws IOException If there is an error getting input from
	 *         the user.
	 */
	private static char getInputs(double[] coords) throws IOException
	{
		byte[] buffer = new byte[1024];  //Buffer to hold byte input
		boolean isOK = false;  // Flag set if input correct
		String theInput = "";  // String input from user
		char coordType = 'A';

		for (int i = 0; i < 3; i++)
		{
			while (!(isOK))
			{
				isOK = true;
				// Prompt input
				if (i == 0) // First argument - type of coordinates
				{
					System.out.print("Enter the type of Coordinates you "
							+ "are inputting ((C)artesian / (P)olar): ");
				}
				else // Second and third arguments
				{
					System.out.print("Enter the value of " 
							+ (coordType == 'C' 
							? (i == 1 ? "X " : "Y ")
									:(i == 1 ? "Rho " : "Theta ")) 
							+ "using a decimal point(.): ");
				}
				System.in.read(buffer);
				theInput = new String(buffer).trim();

				// Verify input
				try{
					if (i == 0) // First argument -- type of coordinates
					{
						if (!((theInput.toUpperCase().charAt(0) == 'C') 
								|| (theInput.toUpperCase().charAt(0) == 'P')))
						{
							//Invalid input, reset flag so user is prompted again
							isOK = false;
						}
						else
						{
							coordType = theInput.toUpperCase().charAt(0);
						}
					}
					else  // Second and third arguments
					{
						//Convert the input to double values
						if (i == 1)
							coords[0] = Double.valueOf(theInput).doubleValue();
						else
							coords[1] = Double.valueOf(theInput).doubleValue();
					}
				}catch(Exception e){
					System.out.println("Incorrect input.");
					isOK = false;  //Reset flag as so not to end while loop
				}
			}
			isOK = false;
		}
		return coordType;
	}

	/**
	 * This method will create random instance and run each method thousands of times.
	 *
	 * @param  sampleSize Sample size
	 * @param  iterations How many times of iterations for each methods
	 */
	private static void runtimeTest(int sampleSize, int iterations)
	{
		System.out.println("Start Testing...");
		System.out.println("-----------------------------------------");
		int sampleNo = 0;
		Random rand = new Random();
		long start, end, totalStart, totalEnd;
		PointCPD2 origin = new PointCPD2(0, 0);
		double[] rotation = new double[sampleSize];
		long[][] runtime = new long[sampleSize][9];
		PointCPD2[] samples = new PointCPD2[sampleSize];

		totalStart = System.currentTimeMillis();
		for(int i = 0; i<sampleSize; i++) {
			double randD1 = rand.nextDouble()*10000; // Random X from [0, 10000]
			double randD2 = rand.nextDouble()*10000; // Random Y from [0, 10000]
			double degree = rand.nextDouble()*10000; // Random degree from [0, 10000]
			samples[i] = new PointCPD2(randD1, randD2);
			rotation[i] = degree;
		}

		while(sampleNo < samples.length) {
			long[] times = new long[9];

			start = System.currentTimeMillis();
			for(int i=0; i<iterations; i++) {
				samples[sampleNo].getX();	// Test getX()
			}
			end = System.currentTimeMillis();
			times[0] = end-start;

			start = System.currentTimeMillis();
			for(int i=0; i<iterations; i++) {
				samples[sampleNo].getY();	// Test getY()
			}
			end = System.currentTimeMillis();
			times[1] = end-start;

			start = System.currentTimeMillis();
			for(int i=0; i<iterations; i++) {
				samples[sampleNo].getRho();	// Test getRho()
			}
			end = System.currentTimeMillis();
			times[2] = end-start;

			start = System.currentTimeMillis();
			for(int i=0; i<iterations; i++) {
				samples[sampleNo].getTheta(); // Test getTheta()
			}
			end = System.currentTimeMillis();
			times[3] = end-start;

			start = System.currentTimeMillis();
			for(int i=0; i<iterations; i++) {
				samples[sampleNo].convertStorageToCartesian();	// Test convertStorageToCartesian()
			}
			end = System.currentTimeMillis();
			times[4] = end-start;

			start = System.currentTimeMillis();
			for(int i=0; i<iterations; i++) {
				samples[sampleNo].convertStorageToPolar();	// Test convertStorageToPolar()
			}
			end = System.currentTimeMillis();
			times[5] = end-start;

			start = System.currentTimeMillis();
			for(int i=0; i<iterations; i++) {
				samples[sampleNo].getDistance(origin);	// Test getDistance()
			}
			end = System.currentTimeMillis();
			times[6] = end-start;

			start = System.currentTimeMillis();
			for(int i=0; i<iterations; i++) {
				samples[sampleNo].rotatePoint(rotation[sampleNo]);	// Test rotatePoint()
			}
			end = System.currentTimeMillis();
			times[7] = end-start;

			start = System.currentTimeMillis();
			for(int i=0; i<iterations; i++) {
				samples[sampleNo].toString();	// Test toString()
			}
			end = System.currentTimeMillis();
			times[8] = end-start;

			// loop variables update
			runtime[sampleNo] = times;
			sampleNo++;
		}
		totalEnd = System.currentTimeMillis(); // get total runtime for test
		System.out.println("Total runtime for runtime Test is "+(totalEnd-totalStart)+"ms.");
		showTestResult(runtime, iterations, sampleSize);
	}

	/**
	 * This method will show the information of the runtime test.
	 *
	 * @param  samples Recieve runtime details
	 * @param  iterations How many times of iterations for each methods
	 * @param  sampleSize The size of samples
	 */
	private static void showTestResult(long[][] samples, int iterations, int sampleSize) {
		long averageGetX = 0, averageGetY = 0, averageGetRho = 0, averageGetTheta = 0, averageCovertC = 0, 
		averageConvertP = 0, averageGetDist = 0, averageRotate = 0, averageToString = 0;
		long[] maximum = new long[9];
		long[] minimum = new long[9];
		for(int i = 0; i < sampleSize; i++) {
			for(int j=0; j<9; j++) {
				maximum[j] = samples[i][j];
				minimum[j] = samples[i][j];
			}
		}
		
		for(int i = 0; i < sampleSize; i++) {
			averageGetX += samples[i][0];
			averageGetY += samples[i][1];
			averageGetRho += samples[i][2];
			averageGetTheta += samples[i][3];
			averageCovertC += samples[i][4];
			averageConvertP += samples[i][5];
			averageGetDist += samples[i][6];
			averageRotate += samples[i][7];
			averageToString += samples[i][8];
			for(int j=0; j<9; j++) {
				if (maximum[j] < samples[i][j]) maximum[j] = samples[i][j];
				if (minimum[j] > samples[i][j]) minimum[j] = samples[i][j];
			}
		}
		System.out.println("\nTest runs on "+sampleSize + " PointCPD2 samples with "+iterations+" iterations for each methods:");
		System.out.println("Average time for GetX() = " + averageGetX/sampleSize + "ms; \nmaximum = " + maximum[0] + "ms, minimum = " + minimum[0] + "ms.");
		System.out.println("Average time for GetY() = " + averageGetY/sampleSize + "ms; \nmaximum = " + maximum[1] + "ms, minimum = " + minimum[1] + "ms.");
		System.out.println("Average time for GetRho() = " + averageGetRho/sampleSize + "ms; \nmaximum = " + maximum[2] + "ms, minimum = " + minimum[2] + "ms.");
		System.out.println("Average time for GetTheta() = " + averageGetTheta/sampleSize + "ms; \nmaximum = " + maximum[3] + "ms, minimum = " + minimum[3] + "ms.");
		System.out.println("Average time for convertStorageToCartesian() = " + averageCovertC/sampleSize + "ms; \nmaximum = " + maximum[4] + "ms, minimum = " + minimum[4] + "ms.");
		System.out.println("Average time for convertStorageToPolar() = " + averageConvertP/sampleSize + "ms; \nmaximum = " + maximum[5] + "ms, minimum = " + minimum[5] + "ms.");
		System.out.println("Average time for getDistance() = " + averageGetDist/sampleSize + "ms; \nmaximum = " + maximum[6] + "ms, minimum = " + minimum[6] + "ms.");
		System.out.println("Average time for rotatePoint() = " + averageRotate/sampleSize + "ms; \nmaximum = " + maximum[7] + "ms, minimum = " + minimum[7] + "ms.");
		System.out.println("Average time for toString() = " + averageToString/sampleSize + "ms; \nmaximum = " + maximum[8] + "ms, minimum = " + minimum[8] + "ms.");
	}
}
