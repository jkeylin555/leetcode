package laioffer;

public class BinarySearch {
    public int binarySearch(int[] input, int left, int right, int target) {
        if (input == null || right - left < 0) {
            return -1;
        }
        int mid = left + (right - left)/2;
        int leftIndex = -1, rightIndex = -1;
        if (input[mid] == target) {
            return mid;
        } else if (input[mid] > target) {
            leftIndex = binarySearch(input, left, mid - 1, target);
        } else {
            rightIndex = binarySearch(input, mid + 1, right, target);
        }
        return leftIndex >= 0 ? leftIndex:rightIndex;
    }

    public int binarySearch2(int[] input, int left, int right, int target) {
        if (input == null || right - left < 0) {
            return -1;
        }
        int mid = left + (right - left)/2;
        if (right - left ==0) {
            if (input[mid] == target) {
                return mid;
            } else {
                return -1;
            }
        }

        int leftIndex = -1, rightIndex = -1;
        if (input[mid] == target) {
            leftIndex = binarySearch(input, mid, right, target);
        } else if (input[mid] > target) {
            leftIndex = binarySearch2(input, left, mid - 1, target);
        } else {
            rightIndex = binarySearch2(input, mid + 1, right, target);
        }
        return leftIndex >= 0 ? leftIndex:rightIndex;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 3, 3, 5, 6, 8, 11, 20};
        BinarySearch binarySearch = new BinarySearch();
        int targetIndex = binarySearch.binarySearch2(arr, 0, arr.length - 1, 1);
        System.out.println(targetIndex);

    }


}
