package Queues;


import java.util.Iterator;
import java.util.NoSuchElementException;


public class BinaryTree implements Iterable<Integer> {


    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node (Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if (left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if (right != null)
                right.print();
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add (int key, int value) {
        root = add(key, value, root);
    }

    public Node add (int key, int value, Node current) {
        if (current == null) {
            return new Node(key, value);
        } else if (key < current.key) {
            current.left = add(key, value, current.left);
        } else if (key > current.key) {
            current.right = add(key, value, current.right);
        } else {
            current.value = value;
        }
        return current;
    }

    public Integer lookup (Integer key) {
        Node current = this.root;
        while (current != null) {
            if (current.key == key) {
                return current.value;
            } else if (current.key < key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return null;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    public class TreeIterator implements Iterator <Integer>{
        private Queue queue;

        public TreeIterator() {
            queue = new Queue();
            if (root != null) {
                queue.add(root);
            }
        }


        @Override
        public boolean hasNext() {
            return (!queue.isEmpty());
        }


        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            BinaryTree.Node current = queue.remove();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            return current.value;

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}