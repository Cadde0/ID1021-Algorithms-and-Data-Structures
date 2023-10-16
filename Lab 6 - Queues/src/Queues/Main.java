package Queues;

public class Main {
    public static void main(String[] args) {

        /*
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.print();
        queue.remove();
        queue.print();
        queue.remove();
        queue.print();

         */


        /*
        BinaryTree tree = new BinaryTree();
        tree.add(5,105);
        tree.add(3,103);
        tree.add(7,107);
        tree.add(8,108);
        tree.add(4,104);
        tree.add(2,102);
        tree.add(1,101);
        tree.add(9,109);

        for (int i : tree) {
            System.out.println("next value " + i);
        }

         */



        ArrayQueue queue = new ArrayQueue(2);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.toString());
        queue.remove();
        System.out.println(queue.toString());



    }
}
