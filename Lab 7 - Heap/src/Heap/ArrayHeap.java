package Heap;

public class ArrayHeap {
    private Node[] Heap;
    private int index;
    private int size;

    public class Node {
        int item;
        int index;

        public Node(int item, int index) {
            this.item = item;
            this.index = index;
        }
    }

    public ArrayHeap(int size) {
        this.size = size;
        this.index = 0;
        Heap = new Node[size];
    }

    /*public void add(int item, int index) {
        Node node = new Node(item, index);
        int current = index;

    }*/

    /*
    public int remove() {
        Node node = Heap[0];
        Heap[0] =
    }

     */
}
