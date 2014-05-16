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

    private int[][][] localMinimum;

    public static void main(String[] args) {
        Task10 t = new Task10();
        t.run();
    }

    private void run()
    {
        generateRandomMatrix();
        print_r(matrix);
        System.out.println();
        print_r(getElementNeighbors(0, 0));
        System.out.println();
        print_r(getElementNeighbors(0, 1));
        System.out.println();
        print_r(getElementNeighbors(1, 0));
        System.out.println();
        print_r(getElementNeighbors(1, 1));
    }

    private void findLocalMinimum()
    {
        // 
    }

    private int[][] getElementNeighbors(int rowIndex, int columnIndex)
    {
        int[][] neighbors = new int[3][3];
        for (int i =0; i < 3; i++) {
            for (int j =0; j < 3; j++) {
                neighbors[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = rowIndex-1; i <= rowIndex+1; i++)
        {
            for (int j = columnIndex-1; j <= columnIndex+1; j++)
            {
                if (i < 0 || i > matrix.length-1) {
                    continue;
                }
                if (j < 0 || j > matrix[i].length-1) {
                    continue;
                }
                neighbors[i-(rowIndex-1)][j-(columnIndex-1)] = matrix[i][j];
            }
        }

        return neighbors;
    }

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