/*************************************************************************************
 *Name:		Ivan Varela
 *ID:		916317108
 *Due Date:	3/6/2016
 *Class:	CSC 0220-03
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

	//Constructor for default implementation
	public SimpleFraction()
	{
		num = 0;
		den = 1;
	}	// end default constructor

	//Constructor that takes two int values and creates a fraction, checks for exception
	public SimpleFraction(int num, int den)
	{
		if(den == 0)
			throw new SimpleFractionException();

		if(den < 0)
		{
			this.num = (num * (-1));
			this.den = (den * (-1));
		}
		else
		{
			this.num = num;
			this.den = den;
		}

		this.reduceSimpleFractionToLowestTerms();
	}	// end constructor

	//Method to set fraction, returns exception if it occurs
	public void setSimpleFraction(int num, int den)
	{
		if(den == 0)
			throw new SimpleFractionException();

		if(den < 0)
		{
			this.num = (num * (-1));
			this.den = (den * (-1));
		}
		else
		{
			this.num = num;
			this.den = den;
		}

		this.reduceSimpleFractionToLowestTerms();

		// return SimpleFractionException if initialDenominator is 0
	}	// end setSimpleFraction

	// return double floating point value	
	public double toDouble()
	{
		return ((double) num/den);
	}	// end toDouble 


	// a/b + c/d is (ad + cb)/(bd)
    // return result which is a new SimpleFraction object
	public SimpleFractionInterface add(SimpleFractionInterface secondFraction)
	{
		SimpleFraction sum = (SimpleFraction) secondFraction;

		int secondNum = sum.num;
		int secondDen = sum.den;

		int newNum = (this.num * secondDen) + (secondNum * this.den);
		int newDen = (this.den*secondDen); 

		sum = new SimpleFraction(newNum, newDen);

		return sum;
	}	// end add


	// a/b - c/d is (ad - cb)/(bd)
    // return result which is a new SimpleFraction object
	public SimpleFractionInterface subtract(SimpleFractionInterface secondFraction)
	{
		SimpleFraction sub = (SimpleFraction) secondFraction;

		int secondNum = sub.num;
		int secondDen = sub.den;		

		int newNum = (this.num * secondDen) - (secondNum * this.den);
		int newDen = (this.den*secondDen);
		sub = new SimpleFraction(newNum, newDen);

		return sub;
	}	// end subtract


	// a/b * c/d is (ac)/(bd)
    // return result which is a new SimpleFraction object
	public SimpleFractionInterface multiply(SimpleFractionInterface secondFraction)
	{
		SimpleFraction mul = (SimpleFraction) secondFraction;

		int secondNum = mul.num;
		int secondDen = mul.den;	

		int newNum = (this.num*secondNum);
		int newDen = (this.den*secondDen);

		mul = new SimpleFraction(newNum, newDen);

		return mul;
	}	// end multiply



	// a/b / c/d is (ad)/(bc)
	// return SimpleFractionException if secondFraction is 0
    // return result which is a new SimpleFraction object
	public SimpleFractionInterface divide(SimpleFractionInterface secondFraction)
	{
		SimpleFraction div = (SimpleFraction) secondFraction;

		if(div.num == 0)
			throw new SimpleFractionException();

		int secondNum = div.num;
		int secondDen = div.den;	

		int newNum = (this.num*secondDen);
		int newDen = (this.den*secondNum);

		div = new SimpleFraction(newNum, newDen);

		return div;
	}	// end divide


    // implement this method!
	// return SimpleFractionException if secondFraction is 0
    // return result which is a new SimpleFraction object
	public SimpleFractionInterface getReciprocal() 
	{
		int newNum = den;
		int newDen = num;

		if(newDen == 0)
			throw new SimpleFractionException();

		SimpleFraction recip = new SimpleFraction(newNum, newDen);

		return recip;
	} // end getReciprocal

	//Check if two objects are equal
	public boolean equals(Object other)
	{
		if(toString().equals(other.toString()))
			return true;
        else
        	return false;
	} // end equals

	//Check if two strings are lexicographically equal
	public int compareTo(SimpleFraction other)
	{
		return toString().compareTo(other.toString());
	} // end compareTo

	//Print the object contents
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
		int integerOne = num;
		int integerTwo = den;

		if(integerOne < 0)
			integerOne = integerOne * (-1);
		if(integerTwo < 0)
			integerTwo = integerTwo * (-1);

		num = num / GCD(integerOne, integerTwo);
		den = den / GCD(integerOne, integerTwo);
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

