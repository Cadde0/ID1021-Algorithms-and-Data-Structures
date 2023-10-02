package Queues;

public class Queue {

    Node head;
    Node tail;

    private class Node {

        BinaryTree.Node item;
        Node next;

        private Node (BinaryTree.Node item, Node list) {
            this.item = item;
            this.next = list;
        }
    }

    public Queue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(BinaryTree.Node item) {
        Node newNode = new Node(item, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public BinaryTree.Node remove() {
        if (isEmpty()) {
            return null;
        }
        BinaryTree.Node removedItem = head.item;
        head = head.next;
        if (head == null) {
            //If the queue is empty after removing
            tail = null;
        }
        return removedItem;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }
}