package Search;

public class FindPeakElement {
	public int findPeak(int[] a) {
		// write your code here
		int start = 0, end = a.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (a[mid] < a[mid - 1]) {
				end = mid;
			} else if (a[mid] < a[mid + 1]) {
				start = mid;
			} else {
				return mid;
			}
		}

		return a[start] > a[end] ? start : end;
	}
}
