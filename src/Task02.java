package src;

import java.util.Scanner;

/**
 * Write a program to fill a two-dimensional array with the given algorithm:
 * from the keyboard is given the number of elements (not equal to 0), which
 * must be on the sides of "mental" square matrix.
 *
 * Input:
 * Please enter number of elements (non-zero): 6
 *
 * Output:
 *         1 1 1 1 1 1
 *         1 0 0 0 0 1
 *         1 0 0 0 0 1
 *         1 0 0 0 0 1
 *         1 0 0 0 0 1
 *         1 1 1 1 1 1
 */
public class Task02 {

    private boolean debugMode;

    private int[][] matrix;

    private static enum Meassage {

    }

    // ------------------------------------------------------------------------------------------------------

    /**
     * [main description]
     * @param args [description]
     */
    public static void main(String[] args) {
        Task02 aTask = new Task02(false);

        aTask.init();        
        if (aTask.isMatrixEmpty()) {
            System.out.println("Error: Matrix is empty. Progrm terminated.\nPlease run it and try again.");
            return;
        }

        aTask.fillMatrix();
        if (! aTask.isMatrixFilled()) {
            System.out.println("Error: Matrix is empty. Progrm terminated.\nPlease run it and try again.");
            return;    
        }
        aTask.print_r();
    }

    // ------------------------------------------------------------------------------------------------------

    /**
     * [Task02 description]
     * @param  debugMode [description]
     * @return           [description]
     */
    public Task02(boolean debugMode) {
        this.debugMode = debugMode;
    }

    // ------------------------------------------------------------------------------------------------------

    /**
     * [init description]
     */
    private void init()
    {
        System.out.print("Please enter number of elements (non-zero): ");
        Scanner in = new Scanner(System.in);
        int elementCount = in.hasNextInt() ? in.nextInt() : 0;
        matrix = (0 == elementCount) ? null : new int[elementCount][elementCount];
        System.out.println();
    }

    // ------------------------------------------------------------------------------------------------------

    /**
     * [isMatrixEmpty description]
     * @return [description]
     */
    private boolean isMatrixEmpty() {
        return (matrix == null);
    }

    // ------------------------------------------------------------------------------------------------------

    /**
     * [isMatrixFilled description]
     * @return [description]
     */
    private boolean isMatrixFilled() {
        return (matrix != null && matrix.length != 0);
    }

    // ------------------------------------------------------------------------------------------------------

    /**
     * [fillMatrix description]
     */
    private void fillMatrix()
    {
        int i = 0;
        for(int[] row : matrix)
        {
            int j = 0;
            for(int item : row)
            {
                matrix[i][j] = 1;
                if (   0 < i && i < row.length-1 
                    && 0 < j && j < row.length-1)
                {
                    if (debugMode) System.out.printf(" [%1$d,%2$d]", i, j);
                    matrix[i][j] = 0;
                }
                j++;
            }
            i++;
            if (debugMode) System.out.println();
        }
    } 

    // ------------------------------------------------------------------------------------------------------

    /**
     * [print_r description]
     */
    private void print_r()
    {
        for(int[] x : matrix) {
            for(int item : x) {
                System.out.printf(" %1$d", item);
            }
            System.out.println();
        }
    }

}