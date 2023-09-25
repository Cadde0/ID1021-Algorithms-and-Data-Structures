package Tree;

import java.util.Random;

public class Bench {
    public static int rndKey = 10;

    private static BinaryTree generateRandomBinaryTree(int size) {
        BinaryTree tree = new BinaryTree();
        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            int key = rnd.nextInt(size);
            int value = rnd.nextInt();
            tree.add(key, value);
        }

        return tree;
    }


    public static void main(String[] args) {
        int[] treeSizes = {100, 1_000, 10_000, 100_000};

        for (int size : treeSizes) {
            BinaryTree binaryTree = generateRandomBinaryTree(size);

            //Start timer
            long startTime = System.nanoTime();

            //Perform lookup
            Integer result = binaryTree.lookup(rndKey);

            //End timer
            long endTime = System.nanoTime();

            long elapsedTime = endTime - startTime;
            System.out.println("Tree sizes: " + size + ", Lookup Time: " + elapsedTime + " nanoseconds");
        }
    }
}
