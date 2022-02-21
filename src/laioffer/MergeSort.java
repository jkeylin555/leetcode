package laioffer;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] array, int start, int end) {
        if (array.length == 0 || array == null) {
            return;
        }
        if (end - start ==0) {
            return;
        }
        int[] sortedArray = new int[end - start + 1];

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
            for (int t = start; t <= end; t++) {
                array[t] = sortedArray[t - start];
            }

//        }

    }

    public void mergeSort2(int[] array, int[] helper, int start, int end) {
        if (array.length == 1 || array.length ==0) {
            return;
        }
        int k = 0;
        for (int i = 0; i < end - start + 1; i++) {
            helper[i] = array[i];
        }

        int mid = start + (end - start - 1)/2;
        int i = start;
        int j = mid + 1;

        mergeSort2(array, helper, start, mid);
        mergeSort2(array, helper, mid + 1, end);

        while(i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                helper[k++] = array[i++];
            } else {
                helper[k++] = array[j++];
            }
        }
        while (i <= mid) {
            helper[k++] = array[i++];
        }
        while (j <= end) {
            helper[k++] = array[j++];
        }
        for (int t = start; t < end; t++) {
            array[t++] = helper[t++];
        }

    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 3, 7, 1, 2, 9, 0, 7, 8};
        MergeSort mergeSort = new MergeSort();
        int[] helper = new int[arr.length];
        mergeSort.mergeSort(arr,0, arr.length- 1);
//        mergeSort.mergeSort2(arr, helper,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
