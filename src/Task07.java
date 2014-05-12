package src;

import java.util.Random;
import java.util.Scanner;

/**
 * Given an array A (n x n). Write a program that rotates the elements
 * in the array to the right/left by one position (the last element 
 * becomes the first).
 *
 * Input:
 *         3 4 5 6
 *         7 8 9 10
 * Output:
 *         10 3 4 5
 *          6 7 8 9
 */

public class Task07 extends AbstractTask {

    private int[][] matrix;

    public static void main()
    {
        System.out.println("Please choose the working mode:");
        System.out.println("(1) - matrix will be generated automaticaly;");
        System.out.println("(2) - matrix will be entered from keyboard.");
        
        Scanner in = new Scanner(System.in);
        int mode = -1;
        try {
            mode = in.hasNextInt() ? in.nextInt() : -1;
        }
        catch (Excepton e) {
            mode = -1;
        }

        if (mode != 1 || mode != 2) {
            System.out.println("Unrecognised working mode. Program terminated.");
            return;
        }
        
        Task07 t = new Task07();
        if (mode == 1) {
            t.fillMatrixWithRandomValues();            
        }
        else {
            t.fillMatrixFromKeyboard();
        }

        System.out.println("Input matrix A:");
        t.print_r(t.matrix);
        
        t.run(t.matrix);
        
        System.out.println("Output matrix A:");
        t.print_r(t.matrix);
    }

    private void fillMatrixFromKeyboard() {

    }

    private void fillMatrixWithRandomValues() {

    }

    private void run(int[][] matrix) {

    }
}