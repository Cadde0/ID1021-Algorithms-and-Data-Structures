package Sorting;

import java.util.Random;

public class SortingBenchmark {

    public static void main(String[] args) {
        // Define an array of different sizes for benchmarking
        int[] arraySizes = {100, 500, 1000, 5000, 10000};
        int numberOfRuns = 1000; // Number of runs for each array size

        for (int size : arraySizes) {
            long minSelectionSortTime = Long.MAX_VALUE;
            long minInsertionSortTime = Long.MAX_VALUE;
            long minMergeSortTime = Long.MAX_VALUE;

            for (int run = 0; run < numberOfRuns; run++) {
                int[] arr = generateRandomArray(size);

                // Benchmark Selection Sort
                long startTime = System.nanoTime();
                Sort.selection_sort(arr.clone());
                long selectionSortTime = System.nanoTime() - startTime;
                minSelectionSortTime = Math.min(minSelectionSortTime, selectionSortTime);

                // Benchmark Insertion Sort
                startTime = System.nanoTime();
                Sort.insertion_sort(arr.clone());
                long insertionSortTime = System.nanoTime() - startTime;
                minInsertionSortTime = Math.min(minInsertionSortTime, insertionSortTime);

                // Benchmark Merge Sort
                startTime = System.nanoTime();
                Merge.start(arr.clone());
                long mergeSortTime = System.nanoTime() - startTime;
                minMergeSortTime = Math.min(minMergeSortTime, mergeSortTime);
            }

            System.out.println("Array Size: " + size);
            System.out.println("Min Selection Sort Time (ns): " + minSelectionSortTime);
            System.out.println("Min Insertion Sort Time (ns): " + minInsertionSortTime);
            System.out.println("Min Merge Sort Time (ns): " + minMergeSortTime);
            System.out.println("-----------------------------");
        }
    }

    // Helper method to generate a random array
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000); // Adjust the range as needed
        }
        return arr;
    }
}

