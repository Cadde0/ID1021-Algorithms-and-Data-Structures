package Sorting;

public class Merge {
    public static void start(int [] org) {
        if (org.length == 0) {
            return;
        }
        int [] aux = new int[org.length];
        sort(org, aux, 0, org.length - 1);
    }
    private static void sort(int [] org, int [] aux, int lo, int hi) {

        if (lo != hi) {
            int mid = (lo + hi) / 2;
            //Sort from lo to mid
            sort(org, aux, lo, mid);
            //Sort from mid + 1 to hi
            sort(org, aux, mid + 1, hi);
            //merge the two sections using the additional array

            merge(org, aux, lo, mid, hi);

        }
    }

    private static void merge(int [] org, int [] aux, int lo, int mid, int hi) {
        //Copy all items from lo to hi from org to aux
        for (int i = 0; i < org.length; i++) {
            aux[i] = org[i];
        }
        //Let's do the merging
        int i = lo; //Index in the first part
        int j = mid + 1; //Index in the second part

        //for all indexes from lo to hi
        for (int k = lo; k <= hi; k++) {
            // if i is greater than mid then
            // move the j'th item to the org array, update j
            if (i > mid) {
                org[k] = aux[j++];
            }
            // else if j is greate than hi then
            // move the i'th item to the org array, update i
            else if (j > hi) {
                org[k] = org[i++];
            }
            // else if the i'th item is smaller than the j¨ath item,
            // move the i'th item to the org array, update i
            else if (aux[i] < aux[j]) {
                org[k] = aux[i++];
            }
            // else
            // move the j'th item to the org array, update j
            else {
                org[k] = aux[j++];
            }
        }
    }
}
