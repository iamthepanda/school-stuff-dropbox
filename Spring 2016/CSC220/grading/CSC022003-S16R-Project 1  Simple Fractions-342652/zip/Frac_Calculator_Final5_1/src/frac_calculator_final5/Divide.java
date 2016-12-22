
package frac_calculator_final5;


public class Divide {
    
    private FractionC FractionA;
    private FractionC FractionB;
    private FractionC Total;
    
public Divide(FractionC FractionA, FractionC FractionB){
    this.FractionA = FractionA;
    this.FractionB = FractionB;
    this.Total = new FractionC();
    Calculate();
}

public void Calculate(){
    Total.setNumerator(FractionA.getNumerator() * FractionB.getDenominator());
    Total.setDenominator(FractionA.getDenominator() * FractionB.getNumerator());
    
}

public void constructFraction(){
    Functions.displayAnswer("Division", "/", FractionA, FractionB, Total);    
    }
    
}
    
    
    

