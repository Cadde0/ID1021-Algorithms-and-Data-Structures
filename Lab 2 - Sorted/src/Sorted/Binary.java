package Sorted;

public class Binary {
    public static boolean search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (true){
            //Jump to the middle
            int index = (last + first) / 2;
            if (array[index] == key) {
                break;
            }
            if (array[index] < key && index < last) {
                //The index position holds something that is less than
                //What we are looking for, index = first possible page
                first = index;
                continue;
            }
            if (array[index] > key && index > first){
                //The index position holds something that is larger than
                //What we are looking for, index = last possible page
                last = index;
                continue;
            }
            if (index)
        }
        return true;
    }
}
