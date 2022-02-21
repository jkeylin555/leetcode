package laioffer;

import java.util.Arrays;

public class BinarySearch {
    //find the target number and return the index of the target number
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

    //find the left most target number
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

    //find the closest number of target and return the index of that number
    public int binarySearch3(int[] input, int left, int right, int target) {
        if (input == null || right - left < 0) {
            return -1;
        }
        int mid = left + (right - left)/2;
        if (right - left <= 1) {
            return Math.abs(input[right] - target) < Math.abs(input[left] - target)? right:left;
        }

        int leftIndex = -1, rightIndex = -1;
        if (input[mid] >= target) {
            leftIndex = binarySearch3(input, left, mid, target);
        } else {
            rightIndex = binarySearch3(input, mid, right, target);
        }
        return leftIndex >= 0 ? leftIndex:rightIndex;
    }

    //find the closest k numbers of target number
    public int binarySearch4(int[] input, int left, int right, int target) {
        if (input == null || right - left < 0) {
            return -1;
        }
        int mid = left + (right - left)/2;
        if (right - left <= 1) {
            return Math.abs(input[right] - target) < Math.abs(input[left] - target)? right:left;
        }

        int leftIndex = -1, rightIndex = -1;
        if (input[mid] >= target) {
            leftIndex = binarySearch4(input, left, mid, target);
        } else {
            rightIndex = binarySearch4(input, mid, right, target);
        }
        return leftIndex >= 0 ? leftIndex:rightIndex;
    }
    public int[] kClosestNumber(int[] input, int left, int right, int target, int k) {
        if (input == null || k <= 0) {
            return new int[]{-1};
        }
        int[] result = new int[k];
        int targeIndex = binarySearch4(input, left, right, target);
        int m = targeIndex, n = targeIndex;
        if (k >= input.length) {
            for(int i = 0; i < input.length; i++) {
                result[i] = i;
            }
        } else if (k == 1) {
            return new int[] {targeIndex};
        } else {
            while (k > 1 && m > left && n < right) {
                k--;
                if (Math.abs(input[m-1] - target) <= Math.abs(input[n+1] - target)) {
                    m--;
                } else n++;
            }
            while (k > 1 && m> left) {
                m--;
                k--;
            }
            while (k > 1 && n < right) {
                n++;
                k--;
            }
            for (int i = m; i <= n; i++) {
                result[i - m] = i;
            }
        }
        return  result;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 3, 3, 5, 6, 8, 11, 20};
        BinarySearch binarySearch = new BinarySearch();
        int[] targetArray = binarySearch.kClosestNumber(arr, 0, arr.length - 1, 10, 3);
        System.out.println(Arrays.toString(targetArray));

    }


}
