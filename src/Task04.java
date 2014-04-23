package src;

/**
 * Write a program to find the maximum element in each row (each column)
 * in the matrix with size m x n.
 */

import java.util.Random;

public class Task04 {

    private int[][] matrix;

    public static void main(String[] args) {
        Random rand     = new Random();
        int rowCount    = rand.nextInt(10);
        int columnCount = rand.nextInt(10);

        Task04 t = new Task04();
        t.init(rowCount, columnCount);
        t.run();
        t.print_r();
    }

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

    private void run() {

    }

    private void print_r()
    {
        for(int[] row : matrix) {
            for(int item : row) {
                System.out.printf(" %1$2d", item);
            }
            System.out.println();
        }
    }
}