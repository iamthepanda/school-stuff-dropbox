
package frac_calculator_final5;

/**
 *
 * @author ArmanHusic
 */
public class Subtract {
    
    private FractionC FractionA;
    private FractionC FractionB;
    private FractionC Total;
    
public Subtract(FractionC FractionA, FractionC FractionB){
        this.FractionA = FractionA;
        this.FractionB = FractionB;
        this.Total = new FractionC();
        Calculate();
    }
    
public void Calculate(){
        if(FractionA.getDenominator() == FractionB.getDenominator()){
            Total.setDenominator(FractionA.getDenominator());
            Total.setNumerator(FractionA.getNumerator() - FractionB.getNumerator());
        } else {
            
    Total.setNumerator((FractionA.getNumerator() * FractionB.getDenominator()) 
                                        - 
            (FractionB.getNumerator() * FractionA.getDenominator()));
  Total.setDenominator(FractionA.getDenominator() * FractionB.getDenominator());
        }
                
    }
   
public void constructFraction(){
       Functions.displayAnswer("Subtraction", "-", FractionA, FractionB, Total);
   }
}
