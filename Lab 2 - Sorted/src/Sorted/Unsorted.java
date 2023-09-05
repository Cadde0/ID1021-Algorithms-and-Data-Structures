package Sorted;

public class Unsorted {
    public static boolean search_unsorted(int[] array, int key){
        for (int index = 0; index < array.length ; index++){
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }
}
