package Sorted;

import java.util.Random;

    public class lab {
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
            int k = 10000;
            int n = 100000;

            long t_total_unsorted = 0;
            long t_total_sorted = 0;

            for (int j = 0; j < n; j++) {
                int[] arr = new int[k];
                int[] arr_sorted = sorted(k);

                Random rnd = new Random();
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = rnd.nextInt(k) + 1;
                }

                long t0_unsorted = System.nanoTime();
                Linear.search_unsorted(arr, rnd.nextInt(k) + 1);
                long t1_unsorted = System.nanoTime();
                long t0_sorted = System.nanoTime();
                Linear.search(arr_sorted, rnd.nextInt(k) + 1);
                long t1_sorted = System.nanoTime();
                t_total_unsorted += t1_unsorted - t0_unsorted;
                t_total_sorted += t1_sorted - t0_sorted;
            }

            System.out.println("Sorted " + t_total_sorted / n);
            System.out.println("Unsorted " + t_total_unsorted / n);
        }
    }

