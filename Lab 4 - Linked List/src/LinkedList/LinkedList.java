package LinkedList;

public class LinkedList {
    Cell first;

    public LinkedList() {
        this.first = null;
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
        Cell itm = new Cell(item,this.first);
        this.first = itm;
    }


    //return the length of the sequence.
     int length() {
        int size = 0;
        Cell index = first;
        while (index != null) {
            size++;
            index = index.tail;
        }
        return size;
    }

    //return true or false depending on if the
    //item can be found in the sequence.
    boolean find(int item) {
        return false;
    }


    // remove the item if it exists in the sequence.
    void remove(int item) {

    }


}
