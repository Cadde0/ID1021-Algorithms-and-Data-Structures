package Heap;

public class Main {
    public static void main(String[] args) {

        /*
        PriorityQueue1 prioQueue1 = new PriorityQueue1();
        prioQueue1.add(1,1);
        prioQueue1.add(2,2);
        prioQueue1.add(3,3);

        prioQueue1.printList();

        prioQueue1.remove();

        prioQueue1.printList();

         */
        /*
        TreeHeap theap = new TreeHeap();

        theap.add(5);
        theap.add(3);
        theap.add(8);
        theap.add(6);
        theap.remove();
        theap.push(1);

         */
        /*
        PriorityQueue2 pq2 = new PriorityQueue2();
        pq2.add(5,2);
        pq2.add(7,3);
        pq2.add(4,1);
        pq2.add(1,4);
        pq2.printList();
        pq2.remove();
        pq2.printList();

         */


        ArrayHeap ah = new ArrayHeap(8);
        ah.add(1,1);
        ah.add(2,2);
        ah.add(4,3);
        ah.printHeap();
        ah.remove();
        ah.printHeap();
    }
}
