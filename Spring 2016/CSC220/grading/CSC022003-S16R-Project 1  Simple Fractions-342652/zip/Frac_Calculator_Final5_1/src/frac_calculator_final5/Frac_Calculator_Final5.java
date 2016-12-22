package frac_calculator_final5;

import java.util.Scanner;

public class Frac_Calculator_Final5 {

    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        FractionC FractionA = new FractionC();
        FractionC FractionB = new FractionC();
        
        
        
        do{
            System.out.println("==Fraction Calculator==");
            System.out.println("Input Numerator : ");
            try{
                FractionA.setNumerator(input.nextInt());
            }catch(Exception e){
                Functions.Error(e);
                return;
            }
            System.out.println("Input Denominator : ");
            try{
                FractionA.setDenominator(input.nextInt());   
            }catch(Exception e){
                Functions.Error(e);
                return;
               }
            if (FractionA.getDenominator() == 0){
                Functions.DenomCantBZero();
               }
            } while (FractionA.getDenominator() == 0);
        System.out.println("1st Fraction : ");
        FractionA.constructFraction();
        System.out.println();
        
        do{
            System.out.println("Input Numerator : ");
            try{
                FractionB.setNumerator(input.nextInt());
            }catch(Exception e){
                Functions.Error(e);
                return;
            }
            System.out.println("Input Denominator : ");
            try{
                FractionB.setDenominator(input.nextInt());
                
            }catch(Exception e){
                Functions.Error(e);
                return;
               }
            if(FractionB.getDenominator() == 0){
                Functions.DenomCantBZero();
                }
            }while (FractionB.getDenominator() == 0);
        System.out.println("2nd Fraction : ");
        FractionB.constructFraction();
        System.out.println();
        
        Add addition = new Add(FractionA, FractionB);
        addition.constructFraction();
        
        Subtract subtraction = new Subtract(FractionA, FractionB);
        subtraction.constructFraction();
        
        Multiply multiplication = new Multiply(FractionA, FractionB);
        multiplication.constructFraction();
        
        Divide division = new Divide(FractionA, FractionB);
        division.constructFraction();
        
       
        System.out.println("Close Program");
    }
      
    }
    

