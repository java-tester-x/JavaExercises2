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

    public static void main(String[] args)
    {
        Task07 t = new Task07();
        t.run();
    }

    private void fillMatrixFromKeyboard()
    {
        Scanner in = new Scanner(System.in);

        int rowCount   = 0;
        int columCount = 0;
        do {
            try {
                System.out.print("\nEnter rows count: ");
                rowCount = in.nextInt();

                System.out.print("\nEnter columns count: ");
                columCount = in.nextInt();
            } catch(Exception e) {}            
        }
        while (rowCount == 0 || columCount == 0);

        matrix = new int[rowCount][columCount];

        int i = 0;
        for (int[] row : matrix)
        {
            int j = 0;
            for (int x : row)
            {
                System.out.printf("\ta[%1$d][%2$d]= ", i, j);
                try {
                    matrix[i][j] = in.nextInt();
                } catch(Exception e) {}
                j++;
            }
            System.out.println();
            i++;
        } 
    }

    private void fillMatrixWithRandomValues()
    {
        int    rowCount;
        int    columnCount;
        Random rand = new Random();
        do {
            rowCount    = rand.nextInt(10);
            columnCount = rand.nextInt(10);
        } while (rowCount == 0 || columnCount == 0);

        matrix = new int[rowCount][columnCount];

        int i  = 0;
        for(int[] row : matrix)
        {
            int j = 0;
            for (int x : row) {
                matrix[i][j] = rand.nextInt(100);
                j++;
            }
            i++;
        }        
    }

    private void transformMatrix()
    {
        int tmp;
        
        // shift to right items in rows
        for(int i=0; i<matrix.length; i++)
        {
            tmp = matrix[i][matrix[i].length-1];
            for(int j = matrix[i].length - 1; j > 0; j--) {                
                matrix[i][j] = matrix[i][j-1];
            }
            matrix[i][0] = tmp;        
        }

        // trick: special transform first column
        tmp = matrix[matrix.length-1][0];
        for(int i = matrix.length-1; i>0; i--) {
            matrix[i][0] = matrix[i-1][0];;
        }
        matrix[0][0] = tmp;
    }

    private void run()
    {
        System.out.println("Please choose the working mode:");
        System.out.println("(1) - matrix will be generated automaticaly;");
        System.out.println("(2) - matrix will be entered from keyboard.");
        
        Scanner in = new Scanner(System.in);
        
        int mode = -1;
        try {
            mode = in.hasNextInt() ? in.nextInt() : -1;
        }
        catch (Exception e) {}

        if ( ! (mode == 1 || mode == 2)) {
            System.out.println("Unrecognised working mode. Program terminated.");
            return;
        }

        if (mode == 1) {
            fillMatrixWithRandomValues();            
        }
        else {
            fillMatrixFromKeyboard();
        }

        System.out.println("Input matrix A:");
        print_r(matrix);
        
        transformMatrix();
        
        System.out.println("Output matrix A:");
        print_r(matrix);
    }
}