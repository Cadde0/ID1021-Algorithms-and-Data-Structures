package Heap;


public class TreeHeap {
    public class Node {
        public int item;
        public Node right;
        public Node left;
        public int size; //Behåll storleken av subtree rooted at this node

        public Node(int item) {
            this.item = item;
            this.left = null;
            this.right = null;
            this.size = 1;  //Initialisera storlek till 1 för den nya noden
        }
    }

    Node root;

    public TreeHeap() {
        root = null;
    }

    public void add(int item) {
        root = add(root, item);
    }

    public Node add(Node node, int item) {
        if (node == null) {
            return new Node(item);
        }

        node.size++; //Increment size of subtree

        //left or right
        if (item < node.item) {
            node.left = add(node.left, item);
        } else {
            node.right = add(node.right, item);
        }
        return node;
    }

    public int remove() {
        if (root == null) {
            throw new IllegalStateException("Empty Heap");
        }
        int min = root.item;
        root = remove(root);
        return min;
    }

    public Node remove(Node node) {
        node.size--;    //Decrement size of subtree

        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        }

        if (node.left.size > node.right.size) {
            //Promote left child
            node.item = node.left.item;
            node.left = remove(node.left);
        } else {
            //Promote right child
            node.item = node.right.item;
            node.right = remove(node.right);
        }
        return node;
    }

    public int push(int incr) {
        return push(root, incr, 0);
    }

    public int push(Node node, int incr, int depth) {
        if (node == null) {
            throw new IllegalStateException("Empty heap");
        }
        depth++;
        node.item += incr;

        if (node.left != null && node.left.item < node.item) {
            //Push updated root left
            depth += push(node.left, incr, depth);
        } else if (node.right != null) {
            //Push updated root right
            depth += push(node.right, incr, depth);
            
        }
        return depth;
    }
}
