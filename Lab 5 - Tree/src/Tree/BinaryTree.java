package Tree;


import java.util.Iterator;
import java.util.Stack;

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

    public BinaryTree () {
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
        private Node next;
        private Stack <Node> stack;

        public TreeIterator() {
            stack = new Stack<>();
            Node current = root;
            while (current != null){
                stack.push(current);
                current = current.left;
            }
        }


        @Override
        public boolean hasNext() {
            return (!stack.isEmpty());
        }


        @Override
        public Integer next() {
            if (!hasNext())
                throw new UnsupportedOperationException();

            Node current = stack.pop();
            if (current.right != null) {
                Node rightBranch = current.right;
                while (rightBranch != null) {
                    stack.push(rightBranch);
                    rightBranch = rightBranch.left;
                }

            }
            return current.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}