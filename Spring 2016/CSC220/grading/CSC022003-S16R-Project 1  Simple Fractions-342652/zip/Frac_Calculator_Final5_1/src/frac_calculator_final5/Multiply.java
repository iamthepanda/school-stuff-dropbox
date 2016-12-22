
package frac_calculator_final5;



public class Multiply {
    
    private FractionC FractionA;
    private FractionC FractionB;
    private FractionC Total;

 public void Calculate(){
        Total.setNumerator( (FractionA.getNumerator() 
                                        * 
                             FractionB.getNumerator()));
        
        Total.setDenominator(FractionA.getDenominator() 
                                        * 
                             FractionB.getDenominator()    );
                
    }

public Multiply(FractionC FractionA, FractionC FractionB){
    this.FractionA = FractionA;
    this.FractionB = FractionB;
    this.Total= new FractionC();
    Calculate();
}

public void constructFraction(){
    Functions.displayAnswer("Multiplication", "x", FractionA, FractionB, Total);
    
}
    
    
    
}
