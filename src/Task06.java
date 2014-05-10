package src;

/**
 * Print out the value of Pi on the basis of an infinite series:
 * 
 *     Pi = 4 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + ...
 *
 * How many members are required for a number of values of 3.14, 3.141, 3.1415, 3.14159?
 */

import java.util.Random;
import java.util.Scanner;

public class Task06 extends AbstractTask {

    public static void main(String[] args)
    {
        Task06 t = new Task06();
        t.calculatePI(0.01);
        t.calculatePI(0.001);
        t.calculatePI(0.0001);
        t.calculatePI(0.00001);
    }

    private void calculatePI(double accuracy)
    {
        int elementCount = 0;
        double prevPi    = 0.0;
        double currPi    = 4.0;
        while (Math.abs(currPi - prevPi) >= accuracy)
        {
            elementCount++;
            prevPi  = currPi;
            currPi += (elementCount % 2 == 0 ? 1 : -1) * 4.0/(2*elementCount + 1);
        }

        System.out.printf("%1$d members are required for calculating PI with accuracy %2$f \n", elementCount, accuracy);
    }
}