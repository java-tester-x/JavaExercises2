package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Find the indexes of all elements of the array with the highest values.
 */
public class Task02 {

    public static void main(String[] args) {
        Task02 aTask = new Task02();
        aTask.print_r();
    }

    private void print_r()
    {
        String path = this.getClass().getClassLoader().getResource("resources/in.txt").getPath().substring(1);
        try {
            Scanner sc = new Scanner(new File(path));
            while(sc.hasNextInt()) {
                System.out.printf(" %1$d", sc.nextInt());
            }
            System.out.println();
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}