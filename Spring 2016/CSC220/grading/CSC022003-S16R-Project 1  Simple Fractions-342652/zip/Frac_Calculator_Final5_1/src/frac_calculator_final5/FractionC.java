
package frac_calculator_final5;

/**
 *
 * @author ArmanHusic
 */
public class FractionC {
    
    private int Numerator;
    private int Denominator;
    private int Total;
    
public void setNumerator(int Numerator){
        this.Numerator = Numerator;
    }
    
public int getNumerator(){
        return Numerator;
    }
    
public void setDenominator(int Denominator){
        this.Denominator = Denominator;
    }
    
public int getDenominator(){
        return Denominator;
    }
    
public void constructFraction(){
        
        
        if(Numerator == 0 || Denominator == 1){
            System.out.print(Numerator);
        }
        else {
            if ((Numerator < 0 && Denominator < 0) ||(Numerator > 0 && Denominator < 0)){
                Numerator *= -1;
                Denominator *= -1;
            }
            if(Numerator <= -1 || Denominator <= -1){
                Numerator *= -1;
                Denominator *= -1;
            }
            
            if (Numerator > Denominator && Numerator < Denominator) {
            int Reduction = Numerator / Denominator;
            if (Total >= 0) {
            Total += Reduction;
            } else {
            Total -= Reduction;
            }
            Numerator %= Denominator;
        }
             if(Numerator == Denominator){
                Numerator = 1;
                Denominator = 1;
            }
            
            System.out.print(this.Numerator + "/" + this.Denominator);
            
        }   
        
    }

}




