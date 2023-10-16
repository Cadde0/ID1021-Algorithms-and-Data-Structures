package Heap;

public class PriorityQueue2 {
    //Smaller numbers higher priority
    //Add method with O n
    //Remove method with O 1
    public class Node {
        int item;
        int index;
        Node next;
        Node prev;

        public Node(int item, int index) {
            this.item = item;
            this.index = index;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    public void add(int item, int index) {
        Node newNode = new Node(item, index);

        if (head == null) {
            head = newNode;
        } else if (index < head.index) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.index < index) {
                current = current.next;
            }
            newNode.next = current.next;
            if (current.next != null){
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new Error("Snälla fungera");
        }
        int remItem = head.item;
        head = head.next;

        return remItem;
    }


        public boolean isEmpty() {
            return head == null;
        }

    public void printList() {
        PriorityQueue2.Node current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
}
