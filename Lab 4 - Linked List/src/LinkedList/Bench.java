package LinkedList;

    public class Bench {
        // Generate an array of size 'n' filled with values from 0 to n-1
        public static int[] generateArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            return arr;
        }

        // Append 'arr2' to 'arr1' by allocating a new array
        public static int[] appendArrays(int[] arr1, int[] arr2) {
            int newSize = arr1.length + arr2.length;
            int[] result = new int[newSize];
            System.arraycopy(arr1, 0, result, 0, arr1.length);
            System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
            return result;
        }

        public static void main(String[] args) {
            int[] nValues = {500, 1000, 5000, 10000, 20000}; // Vary the size of 'n'
            int fixedSizeArray = 100000 ; // Fixed size for the array

            for (int n : nValues) {
                // Benchmark for linked list
                long startTimeList = System.nanoTime();
                LinkedList list = new LinkedList(n);
                long endTimeList = System.nanoTime();

                // Benchmark for array
                long startTimeArray = System.nanoTime();
                int[] arr = generateArray(n);
                long endTimeArray = System.nanoTime();

                // Append arrays
                long startTimeAppend = System.nanoTime();
                int[] appendedArrays = appendArrays(arr, generateArray(fixedSizeArray));
                long endTimeAppend = System.nanoTime();

                // Measure memory allocation for the linked list
                long memoryBeforeList = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                LinkedList appendedList = new LinkedList(fixedSizeArray);
                long memoryAfterList = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

                // Calculate time and memory costs
                long listBuildTime = endTimeList - startTimeList;
                long arrayBuildTime = endTimeArray - startTimeArray;
                long appendTime = endTimeAppend - startTimeAppend;
                long linkedListMemoryCost = memoryAfterList - memoryBeforeList;

                System.out.println("List 'n' size: " + n);
                System.out.println("Array 'n' size: " + n);
                System.out.println("Fixed-size array size: " + fixedSizeArray);
                System.out.println("LinkedList Build Time: " + listBuildTime + " nanoseconds");
                System.out.println("Array Build Time: " + arrayBuildTime + " nanoseconds");
                System.out.println("Array Append Time: " + appendTime + " nanoseconds");
                System.out.println("LinkedList Memory Cost: " + linkedListMemoryCost + " bytes");
                System.out.println("===============================");
            }
        }


    }
