package Search;

public class SearchBigSortedArray {
//	public int searchBigSortedArray(ArrayReader reader, int target) {
//		// write your code here
//		int maxRange = 1;
//		while (reader.get(maxRange - 1) < target) {
//			maxRange = maxRange * 2;
//		}
//		int leftIndex = 0, rightIndex = maxRange;
//		while (leftIndex + 1 < rightIndex) {
//			int mid = (leftIndex + rightIndex) / 2;
//			if (reader.get(mid) == target) {
//				rightIndex = mid;
//			} else if (reader.get(mid) > target) {
//				rightIndex = mid;
//			} else {
//				leftIndex = mid;
//			}
//		}
//
//		if (reader.get(leftIndex) == target) {
//			return leftIndex;
//		}
//		if (reader.get(rightIndex) == target) {
//			return rightIndex;
//		}
//
//		return -1;
//	}
}
