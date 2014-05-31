package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * Highly divisible triangular number
 * 
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
 * 
 * The first ten terms would be:
 * 
 *         1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * Let us list the factors of the first seven triangle numbers:
 * 
 *      1: 1
 *      3: 1,3
 *      6: 1,2,3,6
 *     10: 1,2,5,10
 *     15: 1,3,5,15
 *     21: 1,3,7,21
 *     28: 1,2,4,7,14,28
 * 
 * We can see that 28 is the first triangle number to have over five divisors.
 * 
 * What is the value of the first triangle number to have over five hundred divisors?
 */
public class Task21 {

    private ArrayList<Long> primes    = new ArrayList<Long>();
    private ArrayList<Long> triangles = new ArrayList<Long>();

    public static void main(String[] args) {
        Task21 t = new Task21();
        t.run();
    }

    private void run() {
        System.out.printf("Generating primes up to %1$d ... \n", 5000);
        generatePrimes(5000L);
        //printPrimes();
        
        // some tests
        System.out.println("Running some tests...");
        System.out.printf("The number %1$d have %2$d divisors\n", 12, getNumberDivisors(12));        
        System.out.printf("The number %1$d have %2$d divisors\n", 48, getNumberDivisors(48));
        System.out.printf("The number %1$d have %2$d divisors\n", 17, getNumberDivisors(17));
        System.out.printf("The number %1$d have %2$d divisors\n", 25, getNumberDivisors(25));
        System.out.printf("The number %1$d have %2$d divisors\n", 60, getNumberDivisors(60));
        System.out.printf("The number %1$d have %2$d divisors\n", 100, getNumberDivisors(100));
        System.out.printf("The number %1$d have %2$d divisors\n", 45360, getNumberDivisors(45360));
        System.out.printf("The number %1$d have %2$d divisors\n", 73920, getNumberDivisors(73920));

        // additional tests
        System.out.println("Running some additional tests...");
        System.out.printf("First triangle number to have over %1$d divisors: %2$d\n"
            , 5, getTrianglesWithSpecificNumberOfDivisors(5)
        );
        System.out.printf("First triangle number to have over %1$d divisors: %2$d\n"
            , 50, getTrianglesWithSpecificNumberOfDivisors(50)
        );
        System.out.printf("First triangle number to have over %1$d divisors: %2$d\n"
            , 500, getTrianglesWithSpecificNumberOfDivisors(500)
        );

        // find out solution of problem
        System.out.println("Find out solution for our task...");
        System.out.printf("First triangle number to have over %1$d divisors: %2$d\n"
            , 5000, getTrianglesWithSpecificNumberOfDivisors(5000)
        );
    }

    /**
     * [generateTriangles2 description]
     */
    private long getTrianglesWithSpecificNumberOfDivisors(int specificNumberOfDivisors)
    {
        long i        = 1L;
        long triangle = 0L;
        do {
            triangle += i;
            triangles.add(Long.valueOf(triangle));
            i++;
        }
        while (getNumberDivisors(triangle) < specificNumberOfDivisors);

        return triangle;
    }

    /**
     * [getNumberDivisors description]
     * @param  number [description]
     * @return        [description]
     */
    private long getNumberDivisors(long number)
    {
        long tmp = number;

        ArrayList<Long> factors = new ArrayList<Long>();
        for (long p : primes)
        {
            if (tmp < p) {
                break;
            }

            long numberOfTimesDivisorRepeated = 0;
            while (true)
            {
                if (tmp % p == 0) {
                    numberOfTimesDivisorRepeated++;
                    tmp /= p;
                    continue;
                }

                if (numberOfTimesDivisorRepeated > 0) {
                    factors.add(Long.valueOf(numberOfTimesDivisorRepeated));    
                }

                break;
            }
        }

        // divisors number: a^x + b^y + c^z = (x + 1) * (y + 1) * (z + 1), where:
        // 1) a, b, c are n's prime divisors 
        // 2) x, y, z are the number of times that divisor is repeated)
        long numberDivisors = 1;
        for (long x : factors) {
            numberDivisors *= (x + 1);
        }
        return numberDivisors;
    }

    /**
     * [generatePrimes description]
     * @param hiBoundary [description]
     */
    private void generatePrimes(long hiBoundary)
    {
        for (long i = 2; i <= hiBoundary; i++) {
            if (! isPrime(i)) {
                continue;
            }
            primes.add(Long.valueOf(i));
        }
    }

    /**
     * [isPrime description]
     * @param  number [description]
     * @return        [description]
     */
    private boolean isPrime(long number)
    {
        long factors = 0L;
        for (long i = 1L; i <= number; i++) {
            factors += (number % i == 0L) ? 1L : 0L;
        }
        return (factors == 2L);
    }

    /**
     * [printPrimes description]
     */
    private void printPrimes()
    {
        long i = 1L;
        for (Long x : primes) {
            System.out.printf("%1$d: %2$d\n", i, x);
            i++;
        }
    }

    // private void generateTriangles()
    // {
    //     long i        = 1L;
    //     long triangle = 0L;
    //     do {
    //         triangle += i;
    //         triangles.add(Long.valueOf(triangle));
    //         i++;
    //     }
    //     while (! hasOverSpecificNumberOfDivisors(triangle, 5000));        
    // }


    // private boolean hasOverSpecificNumberOfDivisors(long number, int divisorsNumber)
    // {
    //     int divisors = 0;
    //     for (long i = 1; i <= number; i++) {
    //         divisors += (number % i == 0L) ? 1 : 0;
    //     }
    //     return (divisors >= divisorsNumber);
    // }

    // private void prinTriangles()
    // {
    //     long i = 1L;
    //     for (Long x : triangles) {
    //         System.out.printf("%1$d: %2$d\n", i, x);
    //         i++;
    //     }
    // }
}
