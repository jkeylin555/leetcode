package recursion;

import java.util.Arrays;

public class RotateImage {
	public void rotate(int[][] matrix, int start, int len) {
		if (len < 2) {
			return;
		}
		for (int i = start; i < start + len - 1; i++) {
			int rightTemp = matrix[i][start + len - 1];
			matrix[i][start + len - 1] = matrix[start][i];
			int downTemp = matrix[start + len - 1][start + len - 1 - (i - start)];
			matrix[start + len - 1][start + len - 1 - (i - start)] = rightTemp;
			int leftTemp = matrix[start + len - 1 - (i - start)][start];
			matrix[start + len - 1 - (i - start)][start] = downTemp;
			matrix[start][i] = leftTemp;
		}
		rotate(matrix, start + 1, len - 2);
	}
	public static void main(String[] args) {
		int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};
		RotateImage rotateImage = new RotateImage();
		rotateImage.rotate(matrix2, 0, matrix2.length);
		System.out.println(Arrays.deepToString(matrix2));
	}
}
