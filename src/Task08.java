package src;

import java.util.Random;
import java.util.Scanner;

/**
 * Find a ten-digit number that all digits are different by rules:
 * 1) the number, composed of the first 2 digits is divisible by 2;
 * 2) the number, composed of the first 3 digits is divisible by 3;
 * 3) the number, composed of the first 4 digits is divisible by 4;
 * ...
 * x) and the number itself is divided by 10.
 */

public class Task08 extends AbstractTask {

    public static void main(String[] args) {
        Task08 t = new Task08();
        t.run();
    } 

    private void run()
    {
        long goodNumber = 0L;
        for(long x = 1000000000L; x <= 9999999990L; x+=10)
        {
            if ( ! haveUniqueDigits(x)) {
                continue;
            }
            System.out.println(x);

            if (isGoodNumber(x)) {
                goodNumber = x;
                break;
            }
        }
        System.out.printf("Original number is: %1$d\n", goodNumber);
        
    }

    private boolean haveUniqueDigits(long number)
    {
        boolean flag = false;
        String numberStr = Long.toString(number);
        for(char ch : "0123456789".toCharArray())
        {
            // System.out.println(numberStr);
            // System.out.println((numberStr.replace(String.valueOf(ch), "")));
            if (numberStr.length() - (numberStr.replace(String.valueOf(ch), "")).length() != 1) {
                flag = false;
                break;
            }
            flag = true;
        }
        return flag;
    }

    private boolean isGoodNumber(long number)
    {
        boolean isGood = false;
        for (int j = 2; j <= 10; j++)
        {
            long x = generateNumberAsFirstDigits(number, j);
            // System.out.printf("generateNumberAsFirstDigits(%1$d, %2$d) : %3$d\n", number, j, x);
            if (! isDividedBy(x, j)) {
                isGood = false;
                break;
            }
            isGood = true;
        }
        return isGood;
    }

    private long generateNumberAsFirstDigits(long number, int digitCount) {
        long divider = 1;
        for (int i = 1; i <= 10-digitCount; i++) {
            divider *= 10;
        }
        return number/divider;
    }

    private boolean isDividedBy(long number, int divider)
    {
        if (0 == divider) {
            System.out.println("Error: divider have zero value.");
            return false;
        }
        return (number % divider == 0);
    }

}