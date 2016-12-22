
package frac_calculator_final5;

/**
 *
 * @author ArmanHusic
 */
public class Functions {
    
    public static void Error(Exception e){
        System.out.println("Error" + e.toString());
        }
    public static void DenomCantBZero(){
        System.out.println("ERROR : Cant Divide By 0");
    }
    	
    
     public static void displayAnswer(String operation, String operator,
       
        FractionC FractionA, FractionC FractionB, FractionC Total) {
            System.out.print(operation + " : ");        
        FractionA.constructFraction();
            System.out.print(" " + operator + " ");
        FractionB.constructFraction();
            System.out.print(" = ");
        Total.constructFraction();
            System.out.println();
 }

    
    
    
    
}
