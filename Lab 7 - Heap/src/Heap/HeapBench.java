package Heap;

public class HeapBench {
    public static void main(String[] args) {
        final int numElements = 1023;
        final int maxOrder = 10000;
        final int minIncr = 10;
        final int maxIncr = 100;

        // Create and populate an ArrayHeap
        ArrayHeap arrayHeap = new ArrayHeap(numElements);
        for (int i = 0; i < numElements; i++) {
            int item = (int) (Math.random() * maxOrder);
            int order = i;
            arrayHeap.add(item, order);
        }

        // Create and populate a TreeHeap
        TreeHeap treeHeap = new TreeHeap();
        for (int i = 0; i < numElements; i++) {
            int item = (int) (Math.random() * maxOrder);
            treeHeap.add(item);
        }

        // Benchmark adding elements to both heaps
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            int item = (int) (Math.random() * maxOrder);
            int order = i;
            arrayHeap.add(item, order);
        }
        long arrayHeapAddTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            int item = (int) (Math.random() * maxOrder);
            treeHeap.add(item);
        }
        long treeHeapAddTime = System.nanoTime() - startTime;

        // Benchmark push and remove operations on both heaps
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            int incr = (int) (Math.random() * (maxIncr - minIncr + 1)) + minIncr;
            arrayHeap.remove();
        }
        long arrayHeapPushTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            treeHeap.remove();
            int incr = (int) (Math.random() * (maxIncr - minIncr + 1)) + minIncr;
            treeHeap.add(treeHeap.remove() + incr);
        }
        long treeHeapPushTime = System.nanoTime() - startTime;

        // Output results in nanoseconds
        System.out.println("ArrayHeap - Add Time (ns): " + arrayHeapAddTime);
        System.out.println("ArrayHeap - Push Time (ns): " + arrayHeapPushTime);

        System.out.println("TreeHeap - Add Time (ns): " + treeHeapAddTime);
        System.out.println("TreeHeap - Push Time (ns): " + treeHeapPushTime);
    }
}
