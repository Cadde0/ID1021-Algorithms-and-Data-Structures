package Sorting;

public class Sort {

    public static void selection_sort(int [] array) {

        for (int i = 0; i < array.length - 1; i++){
            int candidate = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < array[candidate])
                    candidate = j;
            }
            swap(array, i, candidate);
        }
    }

    public static void insertion_sort(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array,j,j - 1);
            }
        }
    }

    public static void merge_sort(int [] org, int [] aux, int lo, int mid, int hi) {
        
    }

    public static void quick_sort(int [] array) {

    }

    private static void swap(int [] array,int i, int candidate) {
        int temp = array[candidate];
        array[candidate] = array[i];
        array[i] = temp;
    }

}
