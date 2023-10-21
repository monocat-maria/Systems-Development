package app;

import java.util.Scanner;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
public class Main {

    public static void main(String[] args) {
        String option;
        byte channel;
        
        Scanner input = new Scanner(System.in);
        Control myTV = new Control();
        
        do{
            System.out.println("\tTV\nSelect the TV option:");
            System.out.println("[On]Turn on  [Off]Turn off  [CC]Change Channel  [+]Volume up  [-]Volume down  [I]Info  [X]Close");
            option = input.nextLine();
            
            switch (option) {
                case "On","on": 
                    myTV.on();
                    System.out.println();
                    break;
                case "Off","off":
                    myTV.off();
                    System.out.println();
                    break;
                case "CC","cc":
                    System.out.println("Type the channel number:");
                    channel = input.nextByte();
                    input.nextLine();
                    myTV.changeChannel(channel);
                    System.out.println();
                    break;
                case "+":
                    myTV.upVolume();
                    System.out.println();
                    break;
                case "-":
                    myTV.downVolume();
                    System.out.println();
                    break;
                case "X","x":
                    System.out.println("Closing the program.");
                    break;
                case "I","i":
                    myTV.display();
                    break;
                default:
                    System.out.println("Invalid option.");
                    System.out.println();
                
            }
        }while(!option.equals("X") && !option.equals("x"));
    }
}

// in this case the while only continues the loop if the sentence inside it is true. In that case,
//you have to use the && operator to give false and stop the loop to end the program.

// Logical AND operation
/*true && true; // true
true && false; // false
false && true; // false
false && false; // false

// Logical OR operation
true || true; // true
true || false; // true
false || true; // true
false || false; // false*/
