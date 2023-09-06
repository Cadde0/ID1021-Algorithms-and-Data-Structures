package Sorted;

public class Linear {

    //Unsorted Linear search
    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;

    }

    public static boolean search(int[] array, int key) {
        for (int index = 0; index < array.length; index++){
            if (array[index] == key) {
                return true;
            }
            if (array[index + 1] > key){
                return false;
            }
        }
        return false;

    }


}
