package recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	private void spiralMatrix(int[][] matrix, List<Integer> result, int rowStart, int rowLength, int colStart, int colLen) {
		if (rowLength < 1 || colLen < 1) {
			return;
		}
		for (int i = colStart; i < colStart + colLen; i++) {
			result.add(matrix[rowStart][i]);
		}
		for (int i = rowStart + 1; i < rowStart + rowLength; i++) {
			result.add(matrix[i][colStart + colLen - 1]);
		}
		if (rowLength > 1) {
			for (int i = colStart + colLen - 2; i >= colStart; i--) {
				result.add(matrix[rowStart + rowLength - 1][i]);
			}
		}
        if (colLen > 1) {
			for (int i = rowStart + rowLength - 2; i > rowStart; i--) {
				result.add(matrix[i][colStart]);
			}
		}
		spiralMatrix(matrix, result, rowStart + 1, rowLength - 2, colStart + 1, colLen - 2);
	}
	public static void main(String[] args) {
		int[][] matrix ={{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
		int[][] matrix2 ={{7}, {9},{6}};
		List<Integer> list = new ArrayList<>();
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		spiralMatrix.spiralMatrix(matrix2, list,0, 3, 0, 1);
		System.out.println(list);

	}
}
