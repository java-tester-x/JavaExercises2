package src;

import java.util.Random;
import java.util.Scanner;

/**
 * Given an array of numbers size (mxn). Determine whether you can find a column that
 * splits the array into two parts so that the sum of the elements in the first part 
 * was more than the sum of the elements in the second part. Column itself is not included
 * in the breakable parts.
 */

public class Task09 extends AbstractTask {

    private int[][] matrix;

    public static void main(String[] args) {
        Task09 t = new Task09();
        t.run();
    }

    private void run()
    {
        System.out.println("Generating random matrix...");
        generateRandomMatrix();

        System.out.println("Matrix:");
        print_r(matrix);

        System.out.println("Find out original column (if it possible)...");
        int column =  findColumn();

        if (column == 0) {
            System.out.println("Matrix have no \"split\" column.");
            return;
        }
        System.out.printf("Split column number: %1$d\n", column);
        System.out.printf("Left  part sum: %1$d\n", sumMatrixValues(getLeftMatrixPart(column)));
        System.out.printf("Right part sum: %1$d\n", sumMatrixValues(getRightMatrixPart(column)));
    }

    /**
     * [findColumn description]
     * @return [description]
     */
    private int findColumnBad()
    {
        int column = 0;
        int[][] left;
        int[][] right;
        for (int j = 1; j < matrix[0].length-1; j++)
        {        
            left  = getLeftMatrixPart(j);
            right = getRightMatrixPart(j);
            if (sumMatrixValues(left) > sumMatrixValues(right))
            {
                column = j;
                System.out.println("Left part:");
                print_r(left);
                System.out.println("Right part:");
                print_r(right);
                break;
            }
        }
        return column;
    }

    /**
     * [findColumn2 description]
     * @return [description]
     */
    private int findColumn()
    {
        int column = 0;
        for (int k = 1; k < matrix[0].length -1; k++)
        {
            int leftSum  = 0;
            int rightSum = 0;
            
            int i = 0;
            for(int[] row : matrix)
            {
                int j = 0;
                for (int x : row) {
                    leftSum  += (j < k) ? x : 0;
                    rightSum += (j > k) ? x : 0;
                    j++;
                }
                i++;
            }

            if (leftSum > rightSum) {
                column = k;
                break;
            }
        }
        return column;
    }

    /**
     * 
     */
    private int[][] getLeftMatrixPart(int splitColumnNumber)
    {
        if (splitColumnNumber <= 0) {
            return matrix;
        }

        int[][] leftPart = new int[matrix.length][splitColumnNumber];

        int i = 0;
        for(int[] row : leftPart)
        {
            int j = 0;
            for (int x : row) {
                leftPart[i][j] = matrix[i][j];
                j++;
            }
            i++;
        }

        return leftPart;
    }

    /**
     * 
     */
    private int[][] getRightMatrixPart(int splitColumnNumber)
    {
        if (matrix[0].length - splitColumnNumber - 1 <= 0) {
            return matrix;
        }

        int[][] rightPart = new int[matrix.length][matrix[0].length - splitColumnNumber -1];

        int i = 0;
        for(int[] row : rightPart)
        {
            int j = 0;
            for (int x : row) {
                rightPart[i][j] = matrix[i][splitColumnNumber +j + 1];
                j++;
            }
            i++;
        }

        return rightPart;        
    }

    /**
     * [sumMatrixValues description]
     * @param  m [description]
     * @return   [description]
     */
    private int sumMatrixValues(int[][] m)
    {
        int sum = 0;
        for(int[] row : m) {
            for (int x : row) {
                sum += x;
            }
        }
        return sum;
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