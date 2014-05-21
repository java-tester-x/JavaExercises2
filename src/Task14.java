package src;

import java.util.Random;
import java.util.Scanner;

/**
 * In a linear array with dimension N to determine the maximum and minimum elements;
 * all elements between them place in descending order.
 */

public class Task14 extends AbstractTask {

    private int[][] matrix;

    public static void main(String[] args) {
        Task14 t = new Task14();
        t.run();
    }

    private void run() {
        generateRandomMatrix();

        System.out.println("Input Matrix:");
        print_r(matrix);

        int maxElementIndex = getMaxElementIndex();        
        System.out.printf("Max element %1$d have index %2$d\n"
            , matrix[(maxElementIndex/matrix[0].length)][(maxElementIndex%matrix[0].length)]
            , maxElementIndex
        );

        int minElementIndex = getMinElementIndex();
        System.out.printf("Min element %1$d have index %2$d\n"
            , matrix[(minElementIndex/matrix[0].length)][(minElementIndex%matrix[0].length)]
            , minElementIndex
        );

        int startIndex = maxElementIndex;
        int endIndex   = minElementIndex;
        if (maxElementIndex > minElementIndex)  {
            startIndex = minElementIndex;
            endIndex   = maxElementIndex;
        }

        orderByDescRangeOfElements(startIndex, endIndex);

        System.out.println("Output Matrix:");
        print_r(matrix);
    }

    private void orderByDescRangeOfElements(int startIndex, int endIndex)
    {
        int i = 0;
        for(int[] row : matrix)
        {
            for (int j = 0; j < row.length; j++) {
                if (   row.length * i + j > startIndex
                    && row.length * i + j < endIndex
                ) {
                    //matrix[i][j] = newValue;
                }
            }
            i++;
        }   
    }

    private int getMaxElementIndex()
    {
        int maxElement      = matrix[0][0];
        int maxElementIndex = 0;

        int i  = 0;
        for(int[] row : matrix)
        {
            for (int j = 0; j < row.length; j++) {
                if (matrix[i][j] <= maxElement) {
                    continue;
                }
                maxElement      = matrix[i][j];
                maxElementIndex = i*row.length + j;
            }
            i++;
        }

        return maxElementIndex;
    }

    private int getMinElementIndex()
    {
        int minElement      = matrix[0][0];
        int minElementIndex = 0;

        int i  = 0;
        for(int[] row : matrix)
        {
            for (int j = 0; j < row.length; j++) {
                if (matrix[i][j] >= minElement) {
                    continue;
                }
                minElement      = matrix[i][j];
                minElementIndex = i*row.length + j;
            }
            i++;
        }

        return minElementIndex;
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