package Sorted;

import java.util.Random;

public class duplicates {


        private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

        public static void main(String[] args) {
        int n = 100;
        int k = 100000;
        int[] array = sorted(n);
        int[] arr2 = sorted(n);

        long t_total = 0;
        for (int j = 0; j < k; j++) {

            long t0 = System.nanoTime();
            Binary.duplicate(array, arr2);
            long t1 = System.nanoTime();
            t_total += t1 - t0;
        }
        System.out.println(t_total / k);
    }

}
