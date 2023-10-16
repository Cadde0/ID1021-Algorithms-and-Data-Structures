package Heap;

public class PriorityQueueBench {

    public static void main(String[] args) {
        final int numOperations = 100_000;

        // Benchmark PriorityQueue1
        long start1 = System.nanoTime();
        PriorityQueue1 pq1 = new PriorityQueue1();
        for (int i = 0; i < numOperations; i++) {
            pq1.add(i, i);
        }
        for (int i = 0; i < numOperations; i++) {
            pq1.remove();
        }
        long end1 = System.nanoTime();
        long elapsedTime1 = end1 - start1;
        System.out.println("Time for PriorityQueue1: " + elapsedTime1 / 1e6 + " ms");

        // Benchmark PriorityQueue2
        long start2 = System.nanoTime();
        PriorityQueue2 pq2 = new PriorityQueue2();
        for (int i = 0; i < numOperations; i++) {
            pq2.add(i, i);
        }
        for (int i = 0; i < numOperations; i++) {
            pq2.remove();
        }
        long end2 = System.nanoTime();
        long elapsedTime2 = end2 - start2;
        System.out.println("Time for PriorityQueue2: " + elapsedTime2 / 1e6 + " ms");
    }
}

