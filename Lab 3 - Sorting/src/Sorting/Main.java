package Sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] array = {5,4,3,7,2,9,8,1,6};
        int [] array2 = {5,4,3,7,2,10,8,1,6};
        Sort.selection_sort(array);
        Sort.insertion_sort(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
}
