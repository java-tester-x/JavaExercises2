package src;

/**
 * Fill matrix with values from 1 to N as a spiral. Spiral begin from element a[1,1].
 */

import java.util.Random;
import java.util.Scanner;

public class Task05 extends AbstractTask {

    private int[][] matrix;

    private static enum Actions {GO_RIGHT, GO_DOWN, GO_LEFT, GO_TOP};
    
    public static void main(String[] args)
    {
        int elementCount;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Please enter a positive number as count of elemnts in the matrix: ");
            elementCount = in.hasNextInt() ? in.nextInt() : 0;
        } while (elementCount <= 0);

        Task05 t = new Task05();
        t.fillMatrix(elementCount);

        System.out.printf("Size of matrix: %1$d\n", t.matrix.length);
        t.print_r(t.matrix);
    }

    private void fillMatrix(int elementCount)
    {
        // find out size of the matrix
        int size;
        for (int i = 2; ; i++) {
            if ((int) Math.pow(i, 2) < elementCount) {
                continue;
            }
            size = i; 
            break;
        }

        // init matrix
        matrix = new int[size][size];

        Actions currentAction = Actions.GO_RIGHT;
        int currentNumber     = 1;

        int i;
        int j;
        int leftBoundary   = 0;
        int topBoundary    = 0;
        int rightBoundary  = size-1;
        int bottomBoundary = size-1;
        while (true)
        {
            if (currentNumber > elementCount) {
                break;
            }

            switch (currentAction) {
                case GO_RIGHT:
                    i = topBoundary;
                    for (j = leftBoundary; j <= rightBoundary; j++) {
                        if (currentNumber > elementCount) {
                            break;
                        }
                        matrix[i][j] = currentNumber++;
                    }
                    topBoundary++;
                    currentAction = Actions.GO_DOWN;
                break;

                case GO_DOWN:
                    j = rightBoundary;
                    for (i = topBoundary; i <= bottomBoundary; i++) {
                        if (currentNumber > elementCount) {
                            break;
                        }
                        matrix[i][j] = currentNumber++;
                    }
                    rightBoundary--;
                    currentAction = Actions.GO_LEFT;
                break;

                case GO_LEFT:
                    i = bottomBoundary;
                    for (j = rightBoundary; j >= leftBoundary; j--) {
                        if (currentNumber > elementCount) {
                            break;
                        }
                        matrix[i][j] = currentNumber++;
                    }
                    bottomBoundary--;
                    currentAction = Actions.GO_TOP;
                break;

                case GO_TOP:
                    j = leftBoundary;
                    for (i = bottomBoundary; i >= topBoundary; i--) {
                        if (currentNumber > elementCount) {
                            break;
                        }
                        matrix[i][j] = currentNumber++;
                    }
                    leftBoundary++;
                    currentAction = Actions.GO_RIGHT;
                break;

                default: break;
            }
        }
    }
}
