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
   private   int num;  
   private   int den;  


   public SimpleFraction()
   {
       // implement this method!
       //  Set fraction to 0/1
       num = 0;
       den = 1;
   }   // end default constructor


   public SimpleFraction(int num, int den)
   {
        // implement this method!
        // Set fraction to 0/1. Throw exception if denominator is 0
       if(den == 0){
           throwException();
        
       
    }   
    
       else{
           this.num = num;
           this.den = den;
       }
   }    // end constructor


   public void setSimpleFraction(int num, int den)
   {
       // implement this method!
       // return SimpleFractionException if initial Denominator is 0
       if(den == 0){
           throwException();
       }
       else{
           this.num = num;
           this.den = den;
       }
   }   // end setSimpleFraction


   public double toDouble()
   {
       // implement this method!
       // return double floating point value
       double fractionAsDouble = (double)(num) / (double)(den);

       return fractionAsDouble;
   }   // end toDouble


   public SimpleFractionInterface add(SimpleFractionInterface secondFraction)
   {
       // used when accessing formatted fraction array
       final int numIndex = 0;
       final int denIndex = 1;

        // downcast interface object to SimpleFraction object
       SimpleFraction fractionTwo = (SimpleFraction) secondFraction;

       // convert secondFraction into a string
       String fractionTwoString = fractionTwo.toString();

       // convert current fraction into a string
       String fractionOneString = this.toString();

       // assign a/b and c/d using fractionOneString and fractionTwoString
       int a = getIntNumerator(fractionOneString);
       int b = getIntDenominator(fractionOneString);
       int c = getIntNumerator(fractionTwoString);
       int d = getIntDenominator(fractionTwoString);

       // implement this method! 
       // a/b + c/d is (ad + cb)/(bd)
       int newNum = (a * d) + (c * b);
       int newDen = b * d;

       // get formatted fraction
       int[] formattedFraction = formatProperFraction(newNum, newDen);

       //Create new Simple fraction object with our formatted num and den
       SimpleFraction resultFraction = new SimpleFraction(formattedFraction[numIndex],
           formattedFraction[denIndex]);

       // reduce fraction
       resultFraction.reduceSimpleFractionToLowestTerms();
       // return result which is a new SimpleFraction object
       return resultFraction;
   }   // end add


   public SimpleFractionInterface subtract(SimpleFractionInterface secondFraction)
   {
       // to access formatted fraction array
       
       final int numIndex = 0;
       final int denIndex = 1;

       // downcast secondFraction to SimpleFraction
       SimpleFraction fractionTwo = (SimpleFraction) secondFraction;

       // convert fractions to strings
       String fractionOneString = this.toString();
       String fractionTwoString = fractionTwo.toString();

       // assign a/b and c/d using fractionOneString and fractionTwoString
       int a = getIntNumerator(fractionOneString);
       int b = getIntDenominator(fractionOneString);
       int c = getIntNumerator(fractionTwoString);
       int d = getIntDenominator(fractionTwoString);

       // implement this method! 
       // a/b - c/d is (ad - cb)/(bd)
       int newNum = (a * d) - (c * b);
       int newDen = b * d;

       // get formatted fraction
       int[] formattedFraction = formatProperFraction(newNum, newDen);

       // create new simple fraction object with formatted num and den
       SimpleFraction resultFraction = new SimpleFraction(formattedFraction[numIndex],
           formattedFraction[denIndex]);

       // reduce fraction
       resultFraction.reduceSimpleFractionToLowestTerms();
       
       // return result which is a new SimpleFraction object

       return resultFraction;
   }   // end subtract


   public SimpleFractionInterface multiply(SimpleFractionInterface secondFraction)
   {      
       // to access formatted fraction array
       final int numIndex = 0;
       final int denIndex = 1;
              
        // downcast secondFraction to a SimpleFraction
        SimpleFraction fractionTwo = (SimpleFraction) secondFraction;

        // convert fractions to strings
        String fractionOneString = this.toString();
        String fractionTwoString = fractionTwo.toString();

        // assign a/b and c/d using fractionOneString and fractionTwoString
        int a = getIntNumerator(fractionOneString);
        int b = getIntDenominator(fractionOneString);
        int c = getIntNumerator(fractionTwoString);
        int d = getIntDenominator(fractionTwoString);

       // implement this method!
       // a/b * c/d is (ac)/(bd)
       int newNum = a * c;
       int newDen = b * d;

       // get formatted fraction
       int[] formattedFraction = formatProperFraction(newNum, newDen);

       // create new SimpleFraction object with formatted num and den
       SimpleFraction resultFraction = new SimpleFraction(formattedFraction[numIndex],
           formattedFraction[denIndex]);

       // reduce fraction
       resultFraction.reduceSimpleFractionToLowestTerms();
       // return result which is a new SimpleFraction object

       return resultFraction;
   }   end multiply


   public SimpleFractionInterface divide(SimpleFractionInterface secondFraction)
   {
       // to access formatted fraction array
       final int numIndex = 0;
       final int denIndex = 1;

       // downcast secondFraction to SimpleFraction
       SimpleFraction fractionTwo = (SimpleFraction) secondFraction;

       // convert fractions to strings
       String fractionOneString = this.toString();
       String fractionTwoString = fractionTwo.toString();

       // assign a/b and c/d using fractionOneString and fractionTwoString
       int a = getIntNumerator(fractionOneString);
       int b = getIntDenominator(fractionOneString);
       int c = getIntNumerator(fractionTwoString);
       int d = getIntDenominator(fractionTwoString);

       // check  if denominator is 0. If yes, throw exception
       if(b == 0|| d == 0){
           throwException();
       }

       //implement this method!
       // a/b / c/d is (ad)/(bc)
       int newNum = a * d;
       int newDen = b * c;

       // get formatted fraction
       int[] formattedFraction = formatProperFraction(newNum, newDen);

       // create new SimpleFraction object with formatted num and den
       SimpleFraction resultFraction = new SimpleFraction(formattedFraction[numIndex],
           formattedFraction[denIndex]);

       // reduce fraction
       resultFraction.reduceSimpleFractionToLowestTerms();
       
       // return result which is a new SimpleFraction object

       return resultFraction;
   }   // end divide


   public SimpleFractionInterface getReciprocal()
   {
       // create ints with switched numerator and denominator
       int recipNum = this.den;
       int recipDen = this.num;

       // create new SimpleFraction object using reciprocated values
       SimpleFraction reciprocal = new SimpleFraction(recipNum, recipDen);
       
      // return result which is a new SimpleFraction object
       return reciprocal;
   }  // end getReciprocal


   public boolean equals(Object other)
   {
       // cast other to SimpleFraction
       SimpleFraction otherFraction = (SimpleFraction) other;

       // reduce fractions
       this.reduceSimpleFractionToLowestTerms();
       otherFraction.reduceSimpleFractionToLowestTerms();

       // return the string values of each fraction
        return this.toString().equals(otherFraction.toString());
   }   // end equals


   public int compareTo(SimpleFraction other)
   {
       // convert SimpleFractions to doubles and compare
       double thisDouble = this.toDouble();
       double otherDouble = other.toDouble();

       double result = Double.compare(thisDouble, otherDouble);

       // return int value of double (either negative, 0, or positive result)
        return (int) result;
   }

  
   public String toString()
   {
       return num + "/" + den;
   }
   
   private int getIntDenominator(String fraction){

       // delimit where the denominator starts
       int delimiter = fraction.indexOf("/");

       // get only the denominator of the string, first param is inclusive, so we add one
       // to exclude the backslash
       String stringResult = fraction.substring(delimiter + 1, fraction.length());

       // convert to integer
       int denominator = Integer.parseInt(stringResult);

       return denominator;
   }   // end getIntDenominator
   
   private int getIntNumerator(String fraction){

       //set start index of fraction
       final int fractionStart = 0;

       //delimit where the denominator starts
       int delimiter = fraction.indexOf("/");

       //get only the numerator of the string
       String stringResult = fraction.substring(fractionStart, delimiter);

       //convert to integer
       int numerator = Integer.parseInt(stringResult);

       return numerator;
   }   //end getIntNumerator

   private int[] formatProperFraction(int num, int den){
       //store fraction as [num, den]
       int[] fractionArray = new int[2];

       if(den < 0){
           //Force positive
           den = Math.abs(den);

           //Make num negative instead of den
           fractionArray[0] = -1 * num;
           fractionArray[1] = den;

           return fractionArray;
       }
       else{
           fractionArray[0] = num;
           fractionArray[1] = den;

           return fractionArray;
       }

   }  


   //throw exception for 0 denominator
   private void throwException(){
       throw new SimpleFractionException("Denominator cannot be 0");
   }


   private void reduceSimpleFractionToLowestTerms()
   {
       int gcd = GCD(Math.abs(num), Math.abs(den));

       num = num / gcd;

       den = den / gcd;
      
   }


   /** Task: Computes the greatest common divisor of two integers.
   * @param integerOne   an integer
   * @param integerTwo   another integer
   * @return the greatest common divisor of the two integers */
   private int GCD(int integerOne, int integerTwo)
   {
       int result;

       if (integerOne % integerTwo == 0)
           result = integerTwo;
       else
           result = GCD(integerTwo, integerOne % integerTwo);

       return result;
   }   // end GCD




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

