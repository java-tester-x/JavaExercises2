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

    private int[][] matrix;

    public static void main(String[] args)
    {
        int elementCount = 0;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Please enter a positive number as count of elemnts in the matrix: ");
            elementCount = in.hasNextInt() ? in.nextInt() : 0;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if (elementCount == 0) {
            return;
        }
            

        // Task06 t = new Task06();
        // t.fillMatrix(elementCount);

        // System.out.printf("Size of matrix: %1$d\n", t.matrix.length);
        // t.print_r(t.matrix);
    }

}