package app;

import java.util.Scanner;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
public class Operator {

    Scanner input = new Scanner(System.in);

    public double calculateAddition(double num1, double num2) {
        System.out.println("Type the addend 1:");
        num1 = input.nextDouble();
        System.out.println("Type the addend 2:");
        num2 = input.nextDouble();

        return num1 + num2;
    }

    public double calculateSubtraction(double num1, double num2) {
        System.out.println("Type the minuend:");
        num1 = input.nextDouble();
        System.out.println("Type the subtrahend:");
        num2 = input.nextDouble();

        return num1 - num2;
    }

    public double calculateMultiplication(double num1, double num2) {
        System.out.println("Type the factor 1:");
        num1 = input.nextDouble();
        System.out.println("Type the factor 2:");
        num2 = input.nextDouble();

        return num1 * num2;
    }

    public double calculateDivision(double num1, double num2) {
        System.out.println("Type the dividend:");
        num1 = input.nextDouble();
        System.out.println("Type the divisor:");
        num2 = input.nextDouble();

        return num1 / num2;
    }
}
