package Heap;

public class ArrayHeap {
    private Node[] Heap;
    private int index, size;

    public class Node {
        int item, order;

        public Node(int value, int order) {
            this.item = value;
            this.order = order;
        }
    }

    public ArrayHeap(int size) {
        this.size = size;
        this.index = 0;
        Heap = new Node[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return (i * 2) + 1;
    }

    private int right(int i) {
        return (i * 2) + 2;
    }

    private boolean isLeaf(int i) {
        if (right(i) >= size || left(i) >= size) {
            return true;
        }
        return false;
    }

    public void add(int item, int order) {
        Node element = new Node(item, order);
        if (index >= size)
            return;

        Heap[index] = element;
        int current = index;

        while (Heap[current].order < Heap[parent(current)].order) {
            swap(current, parent(current));
            current = parent(current);
        }

        index++;
    }

    public int remove() {
        Node returnNode = Heap[0];
        Heap[0] = Heap[--index];
        heapIt(0);
        return returnNode.item;
    }

    private void heapIt(int i) {
        if (!isLeaf(i)) {
            if (Heap[i].order > Heap[left(i)].order || Heap[i].order > Heap[right(i)].order) {
                if (Heap[left(i)].order < Heap[right(i)].order) {
                    swap(i, left(i));
                    heapIt(left(i));
                } else {
                    swap(i, right(i));
                    heapIt(right(i));
                }
            }
        }
    }

    // builds the min-heap using the minHeapify
    public void minHeap() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            heapIt(i);
        }
    }

    // Function to print the contents of the heap
    public void printHeap() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.print("Parent : " + Heap[i]);
            if (left(i) < index)
                System.out.print(" Left : " + Heap[left(i)]);
            if (right(i) < index)
                System.out.print(" Right :" + Heap[right(i)]);
            System.out.println();
        }
    }

    // swaps two nodes of the heap
    private void swap(int x, int y) {
        Node tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }
}