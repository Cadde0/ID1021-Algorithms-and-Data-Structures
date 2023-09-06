package Sorted;
public class Binary {
    public static boolean search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;

        while (true){
            //Jump to the middle
            int index = Math.round((last + first) / 2);
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
                //The index position holds something that is less than
                //What we are looking for, index = first possible page
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first){
                //The index position holds something that is larger than
                //What we are looking for, index = last possible page
                last = index - 1;
                continue;
            }
            break;
        }
        return false;

    }

    public static boolean duplicate(int[] array, int[] key) {
        int index = 0;
        for (int i = 0; i < array.length; i++){
            while (true) {
                if (array[index] == key[i]) {
                    return true;
                }
                if (array[index] < key[i]) {
                    return false;
                }

            }

        }
        return false;


    }
}
