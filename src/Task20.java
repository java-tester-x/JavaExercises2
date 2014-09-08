package src;

import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;

/**
 * Summation of primes
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */

public class Task20 {

    public static void main(String[] args) {
        Calendar aCalendar = Calendar.getInstance();
        long startTime = aCalendar.getTimeInMillis();
        // System.out.println(String.format("Start time: %1$s", aCalendar.toString()));

        int  countPrimes = 0;
        long sumPrimes   = 0;
        for (int i=2; i<= 2_000_000; i++) {
            if (! isPrime(i)) {
                continue;
            }
            countPrimes++;
            sumPrimes += i;
        }
        System.out.println(String.format("Count of primes bellow 2_000_000 is %1$d", countPrimes));
        System.out.println(String.format("Sum of primes bellow 2_000_000 is %1$d", sumPrimes));

        aCalendar = Calendar.getInstance();
        long endTime = aCalendar.getTimeInMillis();
        // System.out.println(String.format("End time: %1$s", aCalendar.toString()));

        System.out.println(String.format("Elapsed time: %1$f second(s)", (endTime-startTime)/1000.0));
    }

    private static boolean isPrime(int posInt)
    {
        for (int i = 2; i <= Math.sqrt(posInt); i++)
        {
            if (posInt%i != 0) {
                continue;
            }
            return false;
        }
        return true;
    }
}