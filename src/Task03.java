package src;

/**
 * Write a program to fill the array with values calculated using 
 * the following formula:
 * 
 * a (i) = 1/(i!), i = 0..n
 *  
 * Find the sum of all elements in the array.
 *
 * Input:
 *         Please enter number of elements in the array (non-zero): 6
 *
 * Output:
 * 1,0000  1,0000  0,5000  0,1667  0,0417  0,0083
 * Sum of array items: 2,7167
 */

import java.util.Scanner;

public class Task03 {

    private double[] myArray;

    public static void main(String[] args)
    {
        System.out.printf("Please enter number of elements in the array (non-zero): ");

        Scanner in        = new Scanner(System.in);
        int     itemCount = in.hasNextInt() ? in.nextInt() : 0;
        if (0 >= itemCount) {
            System.out.printf("\nError: Number of elements must be an non-zero positive value!");
            System.out.printf("\nProgram terminated. Please try again.");
            return;
        }
        
        Task03 aTask = new Task03();
        aTask.init(itemCount);

        System.out.println("Output:");
        aTask.print_r();

        System.out.printf("Sum of array items: %1$.4f\n", aTask.getSumItems());
        
    }

    private void init(int itemCount)
    {
        myArray = new double[itemCount];
        long x = 1;
        for(int i = 0; i < itemCount; i++) {
            x *= (0 == i) ? 1 : i;
            myArray[i] = 1.0 / x;
        }
    }

    private double getSumItems() {
        double sum = 0.0;
        for(double item : myArray) {
            sum += item;
        }
        return sum;
    }

    private void print_r()
    {
        for(double item : myArray) {
            System.out.printf("  %1$.4f", item);
        }
        System.out.println();
    }
}