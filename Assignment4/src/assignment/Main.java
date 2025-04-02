package assignment;

import assignment.conversion.Decimal;
import assignment.conversion.Hexadecimal;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Hexadecimal hex = new Hexadecimal();
        Decimal dec = new Decimal();
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter a binary number to be converted: ");
            String binaryString = in.nextLine();
            hex.setBinaryString(binaryString);
            dec.setBinaryString(binaryString);
            hex.convert();
            dec.convert();
            System.out.println("The Hexadecimal value of " + binaryString + " is " + hex.getHexValue());
            System.out.println("The Decimal value of " + binaryString + " is " + dec.getDecimalValue());
        }
        
        
    }    
}
