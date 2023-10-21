/* A class called calculator, which has the attributes “value1”, “value2” and “operation”, and a method calculate(), 
which should return the result according to the chosen values and operation. The operations will be “+” for addition,
“-” for subtraction, “*” for multiplication and “/” for division.*/

package app;

import java.util.Scanner;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Operator calculation = new Operator();
        String option;
        
        do{
            System.out.println("\t-- Calculator --");
            System.out.println("Select an option:\n[A]Addition  [S]Subtraction  [M]Multipication  [D]Division  [X]Close ");
            option = input.nextLine();
                        
            switch (option){
                case "A","a":
                    System.out.println("Result:\nSum = " + calculation.calculateAddition(0, 0) + "\n");
                    break;
                case "S","s":
                    System.out.println("Result:\nDifference = " + calculation.calculateSubtraction(0, 0) + "\n");
                    break;
                case "M","m":
                    System.out.println("Result:\nProduct = " + calculation.calculateMultiplication(0, 0) + "\n");
                    break;
                case "D", "d":
                    System.out.println("Result:\nQuotient = " + calculation.calculateDivision(0, 0) + "\n");
                    break;
                case "X","x":
                    System.out.println("Closing the program.");
                    break;
                default:
                    System.out.println("Invalid option.\n");
                    break;
            }
            
        }while(!option.equals("X")& !option.equals("x"));
    }
}
