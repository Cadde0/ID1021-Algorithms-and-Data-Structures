package Doubly_Linked_List;

import jdk.nashorn.internal.ir.SplitReturn;

public class List {
    Cell first;
    Cell last;
    public List() {
        this.first = null;
        this.last = null;
    }
    public class Cell {
        int head;
        Cell next;

        Cell prev;

        Cell(int val, Cell next, Cell prev) {
            this.head = val;
            this.next = next;
            this.prev = prev;
        }
    }

    //add the item as the firts cell in the sequence.
    void add(int item) {
        Cell newCell = new Cell(item, this.first, null);
        if (first != null) {
            first.prev = newCell;
        }
        first = newCell;
        if (last == null) {
            last = newCell;
        }

    }


    //return the length of the sequence.
    int length() {
        int size = 0;
        Cell current = first;
        while (current != null) {
            size++;
            current = current.next;
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
            current = current.next;
        }
        return false;
    }


    // remove the item if it exists in the sequence.
    void remove(int item) {
        if (isEmpty()) {
            return;
        }
        Cell current = first;

        while (current != null && current.head != item) {
            current = current.next;
        }

        if (current != null) {
            if (current.prev == null) {
                first = current.next;
            }
            else {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
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
            current = current.next;
        }
        System.out.println();
    }

    void unlink(Cell item) {
        if (isEmpty()) {
            return;
        }

        if (item != null) {
            if (item.prev == null) {
                first = item.next;
                if (first != null) {
                    first.prev = null;
                }


            } else if (item.next == null) {
                last = item.prev;
                last.next = null;
            } else {
                item.next.prev = item.prev;
                item.prev.next = item.next;
            }
            item.next = null;
            item.prev = null;
        }

    }

    void insert(Cell item) {
        Cell newCell = new Cell(item.head, first, null);
        if (first != null) {
            first.prev = newCell;
        }
        first = newCell;
        if (last == null) {
            last = newCell;
        }

    }

    public Cell[] getCellArray () {
        Cell current = first;
        Cell [] cells = new Cell[length()];

        int i = 0;
        while (current != null) {
            cells[i++] = current;
            current = current.next;
        }
        return cells;
    }
}

