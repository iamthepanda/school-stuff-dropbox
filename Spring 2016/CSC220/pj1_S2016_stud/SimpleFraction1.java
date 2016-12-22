/*************************************************************************************
 *
 * This class represents a fraction whose numerator and denominator are integers.
 *
 * Requirements:
 *      Implement interfaces: SimpleFractionInterface and Comparable (i.e. compareTo())
 *      Implement methods equals() and toString() from class Object
 *
 *      Should work for both positive and negative fractions
 *      Must always reduce fraction to lowest term 
 *      For a fraction such as 3/-10, it is same as -3/10 (see hints 2. below)
 *      Must display negative fraction as -x/y,
 *         example: (-3)/10 or 3/(-10), must display as -3/10
 *      Must throw SimpleFractionException in case of errors, do not throw other types of exception objects
 *      Must not add new or modify existing data fields
 *      Must not add new public methods
 *      May add private methods
 *
 * Hints:
 *
 * 1. To reduce a fraction such as 4/8 to lowest terms, you need to divide both
 *    the numerator and the denominator by their greatest common denominator.
 *    The greatest common denominator of 4 and 8 is 4, so when you divide
 *    the numerator and denominator of 4/8 by 4, you get the fraction 1/2.
 *    The recursive algorithm which finds the greatest common denominator of
 *    two positive integers is implemnted (see code)
 *       
 * 2. It will be easier to determine the correct sign of a fraction if you force
 *    the fraction's denominator to be positive. However, your implementation must 
 *    handle negative denominators that the client might provide.
 *           
 * 3. You need to downcast reference parameter SimpleFractionInterface to SimpleFraction if  
 *    you want to use it as SimpleFraction. See add, subtract, multiply and divide methods
 *
 * 4. Use "this" to access this object if it is needed
 *
 ************************************************************************************/

package PJ1;

public class SimpleFraction implements SimpleFractionInterface, Comparable<SimpleFraction>
{
	// integer numerator and denominator
	private	int num;	
	private	int den;	

	public SimpleFraction()
	{
		// implement this method!
		// set fraction to default = 0/1
	}	// end default constructor

	public SimpleFraction(int num, int den)
	{
		// implement this method!
	}	// end constructor

	public void setSimpleFraction(int num, int den)
	{
		// implement this method!
		// return SimpleFractionException if initialDenominator is 0
	}	// end setSimpleFraction

	public double toDouble()
	{
                // implement this method!
		// return double floating point value
		return 0.0;
	}	// end toDouble 

	public SimpleFractionInterface add(SimpleFractionInterface secondFraction)
	{
                // implement this method!
		// a/b + c/d is (ad + cb)/(bd)
                // return result which is a new SimpleFraction object
		return null;
	}	// end add

	public SimpleFractionInterface subtract(SimpleFractionInterface secondFraction)
	{
                // implement this method!
		// a/b - c/d is (ad - cb)/(bd)
                // return result which is a new SimpleFraction object
		return null;
	}	// end subtract

	public SimpleFractionInterface multiply(SimpleFractionInterface secondFraction)
	{
                // implement this method!
		// a/b * c/d is (ac)/(bd)
                // return result which is a new SimpleFraction object
		return null;
	}	// end multiply

	public SimpleFractionInterface divide(SimpleFractionInterface secondFraction)
	{
                // implement this method!
		// a/b / c/d is (ad)/(bc)
		// return SimpleFractionException if secondFraction is 0
                // return result which is a new SimpleFraction object
		return null;
	}	// end divide

	public SimpleFractionInterface getReciprocal() 
	{
                // implement this method!
		// return SimpleFractionException if secondFraction is 0
                // return result which is a new SimpleFraction object
		return null;
	} // end getReciprocal


	public boolean equals(Object other)
	{
                // implement this method!
                return false;
	} // end equals


	public int compareTo(SimpleFraction other)
	{
                // implement this method!
                return 0;
	} // end compareTo

	
	public String toString()
	{
		return num + "/" + den;
	} // end toString


	/** Task: Reduces a fraction to lowest terms. */

        //-----------------------------------------------------------------
        //  private methods start here
        //-----------------------------------------------------------------

	private void reduceSimpleFractionToLowestTerms()
	{
                // implement this method!
                //
                // Outline:
                // compute GCD of num & den
                // GCD works for + numbers.
                // So, you should eliminate - sign
                // then reduce numbers : num/GCD and den/GCD
		
	}	// end reduceSimpleFractionToLowestTerms

  	/** Task: Computes the greatest common divisor of two integers.
	 *  @param integerOne	 an integer
	 *  @param integerTwo	 another integer
	 *  @return the greatest common divisor of the two integers */
	private int GCD(int integerOne, int integerTwo)
	{
		 int result;

		 if (integerOne % integerTwo == 0)
			result = integerTwo;
		 else
			result = GCD(integerTwo, integerOne % integerTwo);

		 return result;
	}	// end GCD


	//-----------------------------------------------------------------
	//  Simple test is provided here 

	public static void main(String[] args)
	{
		SimpleFractionInterface firstOperand = null;
		SimpleFractionInterface secondOperand = null;
		SimpleFractionInterface result = null;
                double doubleResult = 0.0;

		SimpleFraction nineSixteenths = new SimpleFraction(9, 16);  // 9/16
		SimpleFraction oneFourth = new SimpleFraction(1, 4);        // 1/4

		System.out.println("\n=========================================\n");
		// 7/8 + 9/16
		firstOperand = new SimpleFraction(7, 8);
		result = firstOperand.add(nineSixteenths);
		System.out.println("The sum of " + firstOperand + " and " +
				nineSixteenths + " is \t\t" + result);
		System.out.println("\tExpected result :\t\t23/16\n");

		// 9/16 - 7/8
		firstOperand = nineSixteenths;
		secondOperand = new SimpleFraction(7, 8);
		result = firstOperand.subtract(secondOperand);
		System.out.println("The difference of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);
		System.out.println("\tExpected result :\t\t-5/16\n");


		// 15/-2 * 1/4
		firstOperand = new SimpleFraction(15, -2); 
		result = firstOperand.multiply(oneFourth);
		System.out.println("The product of " + firstOperand	+
				" and " +	oneFourth + " is \t" + result);
		System.out.println("\tExpected result :\t\t-15/8\n");

		// (-21/2) / (3/7)
		firstOperand = new SimpleFraction(-21, 2); 
		secondOperand= new SimpleFraction(3, 7); 
		result = firstOperand.divide(secondOperand);
		System.out.println("The quotient of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);
		System.out.println("\tExpected result :\t\t-49/2\n");

		// -21/2 + 7/8
		firstOperand = new SimpleFraction(-21, 2); 
		secondOperand= new SimpleFraction(7, 8); 
		result = firstOperand.add(secondOperand);
		System.out.println("The sum of " + firstOperand	+
				" and " +	secondOperand + " is \t\t" + result);
		System.out.println("\tExpected result :\t\t-77/8\n");


                // 0/10, 5/(-15), (-22)/7
		firstOperand = new SimpleFraction(0, 10); 
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t0.0\n");
		firstOperand = new SimpleFraction(1, -3); 
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t-0.333333333...\n");
		firstOperand = new SimpleFraction(-22, 7); 
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t-3.142857142857143");
		System.out.println("\n=========================================\n");
		firstOperand = new SimpleFraction(-21, 2); 
		System.out.println("First = " + firstOperand);
		// equality check
		System.out.println("check First equals First: ");
		if (firstOperand.equals(firstOperand))
			System.out.println("Identity of fractions OK");
		else
			System.out.println("ERROR in identity of fractions");

		secondOperand = new SimpleFraction(-42, 4); 
		System.out.println("\nSecond = " + secondOperand);
		System.out.println("check First equals Second: ");
		if (firstOperand.equals(secondOperand))
			System.out.println("Equality of fractions OK");
		else
			System.out.println("ERROR in equality of fractions");

		// comparison check
		SimpleFraction first  = (SimpleFraction)firstOperand;
		SimpleFraction second = (SimpleFraction)secondOperand;
		
		System.out.println("\ncheck First compareTo Second: ");
		if (first.compareTo(second) == 0)
			System.out.println("SimpleFractions == operator OK");
		else
			System.out.println("ERROR in fractions == operator");

		second = new SimpleFraction(7, 8);
		System.out.println("\nSecond = " + second);
		System.out.println("check First compareTo Second: ");
		if (first.compareTo(second) < 0)
			System.out.println("SimpleFractions < operator OK");
		else
			System.out.println("ERROR in fractions < operator");

		System.out.println("\ncheck Second compareTo First: ");
		if (second.compareTo(first) > 0)
			System.out.println("SimpleFractions > operator OK");
		else
			System.out.println("ERROR in fractions > operator");

		System.out.println("\n=========================================");

		System.out.println("\ncheck SimpleFractionException: 1/0");
		try {
			SimpleFraction a1 = new SimpleFraction(1, 0);		    
		        System.out.println("Error! No SimpleFractionException");
		}
		catch ( SimpleFractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch
		System.out.println("Expected result : SimpleFractionException!\n");

		System.out.println("\ncheck SimpleFractionException: division");
		try {
			SimpleFraction a2 = new SimpleFraction();		    
			SimpleFraction a3 = new SimpleFraction(1, 2);		    
			a3.divide(a2);
		        System.out.println("Error! No SimpleFractionException");
		}
		catch ( SimpleFractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch
		System.out.println("Expected result : SimpleFractionException!\n");



	}	// end main
} // end SimpleFraction

