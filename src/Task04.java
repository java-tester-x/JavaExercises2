package src;

/**
 * Write a program to find the maximum element in each row (each column)
 * in the matrix with size (m x n).
 */

import java.util.Random;

public class Task04 extends AbstractTask {

    private int[][] matrix;

    public static void main(String[] args)
    {
        int    rowCount;
        int    columnCount;
        Random rand = new Random();
        do {
            rowCount    = rand.nextInt(10);
            columnCount = rand.nextInt(10);
        } while (rowCount == 0 || columnCount == 0);

        Task04 t = new Task04();
        t.init(rowCount+1, columnCount+1);
        t.run();

        System.out.printf("Matrix (%1$d x %2$d) :\n", rowCount, columnCount);
        t.print_r(t.matrix);
    }

    /**
     * [init description]
     * @param rowCount    [description]
     * @param columnCount [description]
     */
    private void init(int rowCount, int columnCount)
    {
        Random rand = new Random();
        matrix      = new int[rowCount][columnCount];
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < columnCount; j++) {
                matrix[i][j] = rand.nextInt(100);
            }
        }
    }

    private void run()
    {
        int rowCount    = matrix.length    - 1;
        int columnCount = matrix[0].length - 1;
        for(int i = 0; i < rowCount; i++)
        {
            matrix[i][columnCount] = matrix[i][0];
            for(int j = 0; j < columnCount; j++)
            {
                if (i == 0) {
                    matrix[rowCount][j] = matrix[i][j];
                }

                if (matrix[i][j] > matrix[i][columnCount]) {
                    matrix[i][columnCount] = matrix[i][j];
                }                

                if (matrix[i][j] > matrix[rowCount][j]) {
                    matrix[rowCount][j] = matrix[i][j];
                }                
            }
        }

    }

    protected void print_r(int[][] matrix)
    {
        int i = 0;        
        for(int[] row : matrix)
        {
            int j = 0;
            for(int item : row)
            {
                if (j == row.length - 1) {
                    System.out.printf(" | ");
                }

                if (i == matrix.length - 1 && j == row.length - 1) {
                    System.out.print("  ");
                }
                else {
                    System.out.printf(" %1$4d", item);
                }

                j++;
            }

            System.out.println();
            if (i == matrix.length - 2) {
                System.out.println(String.format("%"+(5*row.length + 3)+"s", " ").replace(" ", "-"));
            }
            
            i++;
        }
    }
}