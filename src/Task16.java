package src;

import java.util.Random;
import java.util.Scanner;

/**
 * Largest palindrome product
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99. 
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Task16 {

    long maxPalindromeX = 100L;
    long maxPalindromeY = 100L;
    long maxPalindrome  = 100000L;

    public static void main(String[] args) {
        Task16 t = new Task16();
        t.run();
    }

    private void run() {
        findPalindromicNumber();
        System.out.printf("The largest palindrome made from the product of %1$d and %2$d: %3$d\n"
            , maxPalindromeX, maxPalindromeY, maxPalindrome);
    }

    private void findPalindromicNumber()
    {
        for (long x = 100; x <= 999; x++)
        {
            if (x % 10 == 0) {
                continue;
            }

            for (long y = 999; y >= 100; y--)
            {
                if (y % 10 == 0) {
                    continue;
                }

                long tmp = x * y;
                if (! isPalindrome(tmp)) {
                    continue;
                }
                if (tmp > maxPalindrome) {
                    maxPalindromeX = x;
                    maxPalindromeY = y;
                    maxPalindrome  = tmp;
                }
            }
        }
    }

    private boolean isPalindrome(long inputNumber)
    {
        String str = String.valueOf(inputNumber);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i-1)) {
                return false;
            }
        }
        return true;
    }
}