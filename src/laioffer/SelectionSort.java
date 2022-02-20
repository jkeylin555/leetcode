package laioffer;

import java.sql.Array;
import java.util.Arrays;

public class SelectionSort {
    public void selectionSort(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }


    }
    public void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 3, 7, 1, 2, 9, 0, 7, 8};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

