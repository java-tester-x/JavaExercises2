package src;

import java.util.Random;
import java.util.Scanner;

/**
 * In the matrix (mxn) to find all local miimumy. Local mimnimum - is an element 
 * of the matrix, which is strictly less than all of its existing elements neighbors.
 * 
 * For example in the matrix:
 *      23  4 51 27
 *      12 34 12 43
 *      11 15 37 18
 *
 * local minima are:
 *      a [0] [1] =  4
 *      a [2] [0] = 11
 */

public class Task10 extends AbstractTask {

    private int[][] matrix;

    public static void main(String[] args) {
        Task10 t = new Task10();
        t.run();
    }

    private void run()
    {
        generateRandomMatrix();
        System.out.println("Input matrix:");
        print_r(matrix);
        System.out.println();
        findAndShowLocalMinimum();
    }

    /**
     * [findLocalMinimum description]
     */
    private void findAndShowLocalMinimum()
    {
        int i = 0;
        for (int[] row : matrix)
        {
            int j = 0;
            for (int x : row)
            {
                if (isLocalMinimum(i, j)) {
                    System.out.printf("Element a[%1$d][%2$d] = %3$d is local minimum\n", i, j, x);
                }
                j++;
            }
            i++;
        }
    }

    /**
     * [isLocalMinimum description]
     * @param  rowIndex    [description]
     * @param  columnIndex [description]
     * @return             [description]
     */
    private boolean isLocalMinimum(int rowIndex, int columnIndex)
    {
        int[][] neighbors = getElementNeighbors(rowIndex, columnIndex);
        int     min       = neighbors[1][1];
        boolean result    = true;
        
        int i = 0;
        for (int[] row : neighbors)
        {
            int j = 0;
            for(int x : row)
            {
                if (3*i+j != 4 && x <= min) {
                    result = false;
                    break;
                }
                j++;
            }
            i++;
        }

        return result;
    }

    /**
     * 
     */
    private int[][] getElementNeighbors(int rowIndex, int columnIndex)
    {
        int[][] neighbors = new int[3][3];
        for (int i =0; i < 3; i++) {
            for (int j =0; j < 3; j++) {
                neighbors[i][j] = Integer.MAX_VALUE;
            }
        }

        int m = rowIndex-1;
        for (int i = 0; i < 3; i++)
        {
            int n = columnIndex-1;
            for (int j = 0; j < 3; j++)
            {
                try {
                    neighbors[i][j] = matrix[m][n];
                }
                catch(Exception e) {}                
                n++;
            }
            m++;
        }        

        return neighbors;
    }

    /**
     * [generateRandomMatrix description]
     */
    private void generateRandomMatrix()
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
}