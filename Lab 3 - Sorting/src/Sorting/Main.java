package Sorting;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //int [] array = {5,4,3,7,2,9,8,1,6};
        //int [] test = { 4, 1, 2, 3};

        //Sort.selection_sort(array);
        //Sort.insertion_sort(array);
        //Merge.start(array);

        //System.out.println(Arrays.toString(array));

        int k = 100;
        int n = 10_000;

        long t_total = 0;

        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            int [] arr = new int[k];
            for (int j = 0; j < k; j++) {
                arr[j] = rand.nextInt(100) + 1;
            }
            long t0 = System.nanoTime();
            //Merge.start(arr);
            //Sort.selection_sort(arr);
            Sort.insertion_sort(arr);
            t_total += System.nanoTime() - t0;
            //System.out.println(Arrays.toString(arr));
        }

        System.out.println(t_total / n);



    }
}
