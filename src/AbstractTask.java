package src;

public abstract class AbstractTask {

    protected void print_r(int[][] matrix)
    {
        for(int[] row : matrix) {
            for(int item : row) {
                System.out.printf(" %1$4d", item);
            }
            System.out.println();
        }
    }

    protected void print_r(long[][] matrix)
    {
        for(long[] row : matrix) {
            for(long item : row) {
                System.out.printf(" %1$4d", item);
            }
            System.out.println();
        }
    }

    protected void print_r(float[][] matrix)
    {
        for(float[] row : matrix) {
            for(float item : row) {
                System.out.printf(" %1$4.2f", item);
            }
            System.out.println();
        }
    }

    protected void print_r(double[][] matrix)
    {
        for(double[] row : matrix) {
            for(double item : row) {
                System.out.printf(" %1$4.2f", item);
            }
            System.out.println();
        }
    }
}