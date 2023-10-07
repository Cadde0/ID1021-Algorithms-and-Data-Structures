package Tree;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Bench {

    public static void main(String[] args) {
        // Adjust the sizes and number of iterations as needed.
        int[] treeSizes = {5000, 50000, 100_000, 500_000, 1_000_000};
        int numIterations = 1000;

        for (int size : treeSizes) {
            int[] keysToLookup = generateRandomKeys(size);

            BinaryTree balancedTree = createBalancedTree(size, keysToLookup);
            BinaryTree unbalancedTree = createUnbalancedTree(size, keysToLookup);

            long balancedMinTime = Long.MAX_VALUE;
            long unbalancedMinTime = Long.MAX_VALUE;

            for (int i = 0; i < numIterations; i++) {
                // Benchmark lookup in the balanced tree.
                long startTime = System.nanoTime();
                for (int key : keysToLookup) {
                    balancedTree.lookup(key);
                }
                long endTime = System.nanoTime();
                long balancedLookupTime = endTime - startTime;
                balancedMinTime = Math.min(balancedMinTime, balancedLookupTime);

                // Benchmark lookup in the unbalanced tree.
                startTime = System.nanoTime();
                for (int key : keysToLookup) {
                    unbalancedTree.lookup(key);
                }
                endTime = System.nanoTime();
                long unbalancedLookupTime = endTime - startTime;
                unbalancedMinTime = Math.min(unbalancedMinTime, unbalancedLookupTime);
            }

            // Convert minimum lookup times from nanoseconds to microseconds.
            double balancedMinTimeMicros = balancedMinTime / 1000.0;
            double unbalancedMinTimeMicros = unbalancedMinTime / 1000.0;

            System.out.println("Tree Size: " + size);
            System.out.println("Minimum Balanced Tree Lookup Time (us): " + balancedMinTimeMicros);
            System.out.println("Minimum Unbalanced Tree Lookup Time (us): " + unbalancedMinTimeMicros);
            System.out.println();
        }
    }

    // Implement createBalancedTree, createUnbalancedTree, and generateRandomKeys as in the previous example.

    private static BinaryTree createBalancedTree(int size, int[] keys) {
        BinaryTree tree = new BinaryTree();
        for (int key : keys) {
            tree.add(key, key); // Use the same keys for both trees.
        }
        return tree;
    }

    private static BinaryTree createUnbalancedTree(int size, int[] keys) {
        BinaryTree tree = new BinaryTree();
        for (int key : keys) {
            tree.add(key, key); // Use the same keys for both trees.
        }
        return tree;
    }

    private static int[] generateRandomKeys(int size) {
        int[] keys = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            keys[i] = random.nextInt(size * 2); // Generating random keys within a range.
        }
        return keys;
    }
}
