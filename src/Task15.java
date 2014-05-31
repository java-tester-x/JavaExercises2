package src;

import java.util.Random;
import java.util.Scanner;

/**
 * Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

public class Task15 {

    public static void main(String[] args) {
        Task15 t = new Task15();
        t.run();
    }

    private void run() {
        System.out.printf("The sum of all the multiples of 3 or 5 below 1000 = %1$d"
            , getSumOfMultiplesOfThreeAndFive(1000)
        );
    }

    private boolean isMultipleOf(long inputNumber, long divisorNumber)
    {
        return (inputNumber % divisorNumber == 0);
    }

    private long getSumOfMultiplesOfThreeAndFive(long boundaryNumber)
    {
        long sum = 0;
        for (long i = 3; i < boundaryNumber; i++)
        {
            if (! (isMultipleOf(i, 3) || isMultipleOf(i, 5))) {
                continue;
            }
            sum += i;
        }
        return sum;
    }
}