package Heap;

import java.util.Random;

public class TreeHeapBench {

    public static void main(String[] args) {
        TreeHeap heap = new TreeHeap();
        Random random = new Random();

        // Step 1: Add 1023 elements with random values
        for (int i = 0; i < 1023; i++) {
            int randomValue = random.nextInt(10001); // Random values between 0 and 10000
            heap.add(randomValue);
        }

        int numPushOperations = 100;
        int minIncrement = 10;
        int maxIncrement = 100;

        int[] depthStats1 = new int[numPushOperations];
        long[] timeStats1 = new long[numPushOperations];

        int[] depthStats2 = new int[numPushOperations];
        long[] timeStats2 = new long[numPushOperations];

        for (int i = 0; i < numPushOperations; i++) {
            int increment = random.nextInt(maxIncrement - minIncrement + 1) + minIncrement;

            // Benchmark 1: Measure time and depth for the push operation
            long startTime1 = System.nanoTime();
            depthStats1[i] = heap.push(increment);
            long endTime1 = System.nanoTime();
            timeStats1[i] = endTime1 - startTime1;

            // Benchmark 2: Dequeue and re-add elements, then measure time and depth for the push operation
            int dequeuedValue = heap.remove(); // Dequeue the element with the highest priority
            int newPriority = dequeuedValue + increment;

            long startTime2 = System.nanoTime();
            heap.push(newPriority);
            long endTime2 = System.nanoTime();
            depthStats2[i] = heap.push(increment);
            timeStats2[i] = endTime2 - startTime2;
        }

        // Print depth statistics and execution times for Benchmark 1
        System.out.println("Benchmark 1: Depth Statistics and Execution Times for Push Operations:");
        for (int i = 0; i < numPushOperations; i++) {
            System.out.println("Push " + (i + 1) + " Depth: " + depthStats1[i] + " Time (ns): " + timeStats1[i]);
        }

        // Print depth statistics and execution times for Benchmark 2
        System.out.println("\nBenchmark 2: Depth Statistics and Execution Times for Push Operations (Dequeue and Re-add):");
        for (int i = 0; i < numPushOperations; i++) {
            System.out.println("Push " + (i + 1) + " Depth: " + depthStats2[i] + " Time (ns): " + timeStats2[i]);
        }
    }
}
