package Queues;

public class ArrayQueue {
    int[] queue;
    int size;
    int head = 0;
    int tail = 0;

    public ArrayQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    private void grow() {
        int oldSize = this.size;
        int[] oldQueue = this.queue;
        size = size * 2;
        queue = new int[size];
        for (int i = 0; i < oldSize; i++) {
            queue[i] = oldQueue[i];
        }
    }

    public void add(int item) {
        if (tail == size - 1)
            grow();
        queue[tail++] = item;
    }

    /*
    public int remove() {
        if (head != tail) {
            int value = queue[head];

            for (int i = 0; i < tail - 1; i++) {
                queue[i] = queue[i + 1];
            }

            if (tail < size)
                queue[tail] = 0;

            tail--;

            return value;
        } else {
            throw new Error("Empty Queue");
        }
    }

     */

    public int remove() {
        if (head != tail) {
            int value = queue[head];
            head++;
            return value;
        } else {
            throw new Error("Empty Queue");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = head; i < tail; i++) {
            sb.append(queue[i] + ", ");
        }
        return sb.toString();
    }




}
