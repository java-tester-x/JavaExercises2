package src.util;

public class ArrayUtil {

    public static void print_r(int[][] matrix)
    {
        for(int[] x : matrix) {
            for(int item : x) {
                System.out.printf(" %1$d", item);
            }
            System.out.println();
        }
    }

    public static void print_r(long[][] matrix)
    {
        for(long[] x : matrix) {
            for(long item : x) {
                System.out.printf(" %1$d", item);
            }
            System.out.println();
        }
    }

    public static void print_r(double[][] matrix)
    {
        for(double[] x : matrix) {
            for(double item : x) {
                System.out.printf(" %1$f.4", item);
            }
            System.out.println();
        }
    }
}