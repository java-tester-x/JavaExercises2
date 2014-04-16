package src;

import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


/**
 * Find the indexes of all elements of the array with the highest values.
 */
public class Task01 {

    private int[] theArray;

    public static void main(String[] args)
    {
        Task01 aTask = new Task01();

        System.out.println("Init...");
        aTask.init();

        System.out.println("Array of integers:");        
        aTask.print_r();

        System.out.println("Indexes of elements with the highest values:");
        aTask.find(aTask.getMaxValue());
    }

    /**
     * [find description]
     * @param value [description]
     */
    private void find(int value)
    {
        for(int i = 0; i < theArray.length; i++) {
            if (theArray[i] != value) {
                continue;
            }
            System.out.printf(" %1$d", i);
        }
        System.out.println();
    }

    /**
     * [init description]
     */
    private void init()
    {
        try {
            List<Integer> list = new ArrayList<Integer>();

            // read integers form input file
            Scanner sc = new Scanner(new File("resources/in.txt"));
            while (sc.hasNextInt()) {
                list.add(sc.nextInt());
            }

            // convert Integer[] to int[]
            theArray = new int[list.size()];
            for (int i=0; i < theArray.length; i++) {
                theArray[i] = list.get(i).intValue();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }    
    }

    /**
     * [getMaxValue description]
     * @return [description]
     */
    private int getMaxValue()
    {
        if (theArray.length == 0) {
            return 0;
        }

        int maxValue = theArray[0];
        for(int x : this.theArray) {
            if (x < maxValue) {
                continue;
            }
            maxValue = x;
        }
        return maxValue;
    }

    /**
     * [print_r description]
     */
    private void print_r() {
        for(int x : this.theArray) {
            System.out.print(x+", ");            
        }
        System.out.println();
    }
}