package laioffer;

public class MergeSort {

    public void mergeSort(int[] array, int start, int end) {
        if (array.length == 1 || array.length ==0) {
            return;
        }
        int[] sortedArray = new int[array.length - 1];

        int mid = start + (end - start - 1)/2;
        int i = start;
        int j = mid + 1;
        int k = 0;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
//        while (start < end) {
            while(i <= mid && j <= end) {
                if (array[i] <= array[j]) {
                    sortedArray[k++] = array[i++];
                } else {
                    sortedArray[k++] = array[j++];
                }
            }
//            while (i > mid && j <= end) {
//                sortedArray[k++] = array[j++];
//            }
//            while (j > end && i <= mid) {
//                sortedArray[k++] = array[i++];
//            }
            while (i <= mid) {
                sortedArray[k++] = array[i++];
            }
            while (j <= end) {
                sortedArray[k++] = array[j++];
            }
            for (int t = start; t < end; t++) {
                array[t++] = sortedArray[t++];
            }

//        }

    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 3, 7, 1, 2, 9, 0, 7, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length);
        System.out.println(arr);
    }
}
