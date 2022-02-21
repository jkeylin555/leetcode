package laioffer;

public class BinarySearch {
    public int binarySearch(int[] input, int left, int right, int target) {
        if (input == null || right - left ==0) {
            return -1;
        }
        int mid = left + (right - left)/2;
        if (input[mid] == target) {
            return mid;
        } else if (input[mid] >= target) {
            binarySearch(input, left, mid - 1, target);
        } else {
            binarySearch(input, mid + 1, right, target);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 8, 11, 20};
        BinarySearch binarySearch = new BinarySearch();
        int targetIndex = binarySearch.binarySearch(arr, 0, arr.length, 6);
        System.out.println(targetIndex);

    }


}
