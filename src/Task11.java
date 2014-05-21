package src;

import java.util.Random;
import java.util.Scanner;

/**
 * In the array A (m x n) calculate the amount of elements,
 * starting with the number from K to L. Show elements and
 * their sum on the screen.
 */

public class Task11 extends AbstractTask {

    private String[] messages = {
        "\nPlease enter index of start element (from %1$d to %2$d): "
    ,   "\nPlease enter index of end element (from %1$d to %2$d): "
    ,   "\nOoops! Start index must have lowest value than end index. Please try again."
    ,   "\nOoops! You enter bad value for the element's index. Please try again."
    ,   "\nRang elements:"
    ,   "\nSum of elements: %1$d"
    };

    private int[][] matrix;


    public static void main(String[] args) {
        Task11 t = new Task11();
        t.run();
    }

    /**
     * [run description]
     */
    private void run()
    {
        generateRandomMatrix();
        int elementCount = matrix.length * matrix[0].length;

        System.out.println("Matrix:");
        print_r(matrix);

        Scanner in = new Scanner(System.in);
        
        int startIndex;
        int endIndex;
        do {
            try {
                System.out.print(String.format(messages[0], 0, (elementCount-1)));
                startIndex = in.nextInt();

                System.out.print(String.format(messages[1], 0, (elementCount-1)));
                endIndex = in.nextInt();

                if (startIndex < endIndex) {
                    break;
                }
                System.out.println(messages[2]);
            }
            catch (Exception e) {
                System.out.println(messages[3]);
            }
        } while (true);
        
        System.out.println(messages[4]);
        int[] elements = getRangeElements(startIndex, endIndex);
        print_r(elements);

        System.out.println(String.format(messages[5], getSumElements(elements)));
    }

    private void print_r(int[] array) {
        for(int x : array) {
            System.out.printf(" %1$d", x);
        }
        System.out.println();
    }

    /**
     * [getSumElements description]
     * @param  array [description]
     * @return       [description]
     */
    private int getSumElements(int[] array)
    {
        int sum = 0;
        for(int x : array) {
            sum += x;
        }
        return sum;
    }

    /**
     * 
     */
    private int[] getRangeElements(int startIndex, int endIndex)
    {
        int[] elements = new int[(endIndex - startIndex + 1)];
        
        int k = 0;
        int i = 0;
        for(int[] row : matrix)
        {
            int j = 0;
            for (int x : row)
            {
                if (   row.length * i + j >= startIndex
                    && row.length * i + j <= endIndex
                ) {
                    elements[k] = matrix[i][j];
                    k++;
                }
                j++;
            }
            i++;
        }

        return elements;
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