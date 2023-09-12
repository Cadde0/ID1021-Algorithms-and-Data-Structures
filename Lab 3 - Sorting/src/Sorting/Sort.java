package Sorting;

public class Sort {

    public static void selection_sort(int [] array) {

        for (int i = 0; i < array.length - 1; i++){
            int cand = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < array[cand])
                    cand = j;
            }
            swap(array, i, cand);
        }
    }

    public static void insertion_sort(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array,j,j - 1);
            }
        }
    }

    private static void swap(int [] array,int i, int cand) {
        int temp = array[cand];
        array[cand] = array[i];
        array[i] = temp;
    }

}
