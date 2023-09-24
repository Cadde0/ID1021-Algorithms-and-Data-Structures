package Doubly_Linked_List;



public class Main {
    public static void main(String[] args) {
        List list1 = new List();
        list1.add(18);
        list1.add(25);
        list1.add(13);
        list1.printList();
        boolean x = list1.find(25);
        System.out.println("Find 25 : " + x);

        List.Cell[] cells = list1.getCellArray();
        list1.unlink(cells[1]);
        list1.printList();



    }
}
