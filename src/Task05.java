package src;

/**
 * Fill matrix with values from 1 to N as a spiral. Spiral begin from element a[1,1].
 */

import java.util.Random;
import java.util.Scanner;

public class Task05 extends AbstractTask {

    private int[][] matrix;
    
    public static void main(String[] args)
    {
        int elementCount;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Please enter a positive number as count of elemnts in the matrix: ");
            elementCount = in.hasNextInt() ? in.nextInt() : 0;
        } while (elementCount <= 0);

        Task05 t = new Task05();
        t.fillMatrix(elementCount);
        t.print_r(t.matrix);
    }

    private void fillMatrix(int elementCount)
    {
        int size;
        for (int i = 2; ; i++) {
            if ((int) Math.pow(i, 2) < elementCount) {
                continue;
            }
            size = i; 
            break;
        }

        System.out.printf("Size of matrix: %1$4d\n", size);
        matrix = new int[size][size];
    }
}
