package Sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] array = {5,4,3,7,2,9,8,1,6};
        int [] test = { 4, 1, 2, 3};

        //Sort.selection_sort(array);
        //Sort.insertion_sort(array);
        Merge.start(array);

        System.out.println(Arrays.toString(array));

    }
}
