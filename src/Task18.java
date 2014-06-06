package src;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.Scanner;

/**
 * Special Pythagorean triplet
 *
 * A Pythagorean triplet is a set of three natural numbers,
 * a < b < c, for which,  a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Task18 {

    public static void main(String[] args) {
        Task18 t = new Task18();
        t.run();
    }

    private void run()
    {
        BigDecimal bd = new BigDecimal(0);
        for (int i = 100; i <= 400; i++)
        {
            for (int j = i+1; j <= 500; j++)
            {
                double x = new BigDecimal(Math.hypot(i, j)).setScale(9, RoundingMode.HALF_UP).doubleValue();
                int    k = (int) x;
                if (x - k != 0.0D) {
                    continue;
                }

                if (! isPythagoreanTriplet(i, j, k)) {
                     continue;
                }
                System.out.printf("a = %1$d b = %2$d c = %3$d \n", i, j, k);
            }
        }
    }

    private boolean isPythagoreanTriplet(int a, int b, int c) {
        if (a > b) return false;
        if (b > c) return false;
        return (a + b + c == 1000);
    }
}