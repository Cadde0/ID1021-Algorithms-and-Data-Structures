package Heap;

public class PriorityQueue1 {

    //Smaller numbers higher priority
    //Add method with O 1
    //Remove method with O n


    public class Node {

        int item;
        int index;
        Node next;

        public Node(int item, int index) {
            this.item = item;
            this.index = index;

            this.next = null;
        }
    }

    Node head;
    Node tail;

    public void add(int item, int index) {
        Node newNode = new Node(item, index);
        if (head == null){
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public int remove() {
        if (isEmpty()) {
            throw new Error("Nej Tack");
        }

        Node min = head;
        Node prevNode = null;
        Node current = head.next;
        Node prevMin = null;

        while (current != null) {
            if (current.item < min.item) {
                min = current;
                prevNode = prevMin;
            }
            prevMin = current;
            current = current.next;
        }
        if (prevNode == null) {
            head = min.next;
        } else {
            prevNode.next = min.next;
        }

        if (min == tail) {
            tail = prevNode;
        }

        return min.item;

    }

    public boolean isEmpty() {
        return head == null;
    }
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }



}
