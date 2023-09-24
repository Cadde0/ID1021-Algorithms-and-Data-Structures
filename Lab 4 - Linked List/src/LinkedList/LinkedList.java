package LinkedList;

public class LinkedList {
    Cell first;

    public LinkedList(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {
            last = new Cell(i,last);
        }
        first = last;
    }

    private class Cell {
        int head;
        Cell tail;

        Cell(int val, Cell t1) {
            this.head = val;
            this.tail = t1;
        }
    }

    //add the item as the firts cell in the sequence.
    void add(int item) {
        Cell itm = new Cell(item, this.first);
        this.first = itm;
    }


    //return the length of the sequence.
    int length() {
        int size = 0;
        Cell current = first;
        while (current != null) {
            size++;
            current = current.tail;
        }
        return size;
    }

    //return true or false depending on if the
    //item can be found in the sequence.
    boolean find(int item) {
        Cell current = first;
        while (current != null) {
            if (current.head == item) {
                return true;
            }
            current = current.tail;
        }
        return false;
    }


    // remove the item if it exists in the sequence.
    void remove(int item) {
        if (isEmpty()) {
            return;
        }

        Cell current = first;
        Cell previous = null;

        while (current != null && current.head != item) {
            previous = current;
            current = current.tail;
        }

        if (current != null) {
            if (previous == null) {
                first = current.tail;
            }
            else {
                previous.tail = current.tail;
            }
        }
    }

    boolean isEmpty() {
        return this.first == null;
    }

    public void printList() {
        Cell current = first;
        while (current != null) {
            System.out.print(current.head + " ");
            current = current.tail;
        }
        System.out.println();
    }

    public int topValue() {
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return first.head;
    }

    public void append(LinkedList b) {
        Cell next = this.first;
        while (next.tail != null) {
            next = next.tail;
        }
        next.tail = b.first;
        b.first = null;
    }
}