package Stack;

import java.util.LinkedList;
import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		// validate inputs
		if (matrix == null || matrix.length == 0) return 0;


		int[] histo = new int[matrix[0].length + 1];
		int sum = 0;

		// if the value that is on top of an entry is not 0;
		// we know this entry can be regarded as a height boundary of the rectangle
		// otherwise, the height boundary at this entry will be 0;
		// and we can process this matrix, row by row;

		// and for each row, we have values of those potential boundaries of rectangles
		// so the question is reduced to find the largest rectangle on each row
		// if each possible boundary of the rectangle is corresponding to
		// each entry in this row.

		// then we will need a stack to solve this
		for (int i = 0; i < matrix.length; i++){
			// for each row, we need to find the largest rectangle
			// to initialize the stack structure, we need to specify the first
			// start wrapper boundary
			Stack<Integer> s = new Stack<>();
			s.push(-1);
			// then we will calculate the area of rectangles formed from left to right of the current row.
			for (int j = 0; j <= matrix[0].length; j++){
				// if is the last end wrapper boundary (which is at the index
				// of value matrix[0].length, set the height of this boundary to be                   // 0)
				if (j == matrix[0].length){
					histo[j] = 0;
				}
				else {
					histo[j] = matrix[i][j] == '0' ? 0 : histo[j] + 1;
				}

				// for each j, if h[j] >= height of the current rectangle, we just
				// expand the rectangle (push j onto the stack)
				// if h[j] < height of the current rectangle, we know j will serve
				// as an end wrapper boundary of one or more rectangels;
				while (s.peek() != -1 && histo[j] < histo[s.peek()]){
					// we need to calcualte the rectangle area based on
					// the end wrapper boundary and the start wrapper boundary
					int height = histo[s.pop()];
					int startWrapper = s.peek();
					int endWrapper = j;
					sum = Math.max(sum, height * (endWrapper - startWrapper - 1));
				}
				// expand the rectangle
				s.push(j);
			}

		}
		return sum;
	}

	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		MaximalRectangle maximalRectangle = new MaximalRectangle();
		int res = maximalRectangle.maximalRectangle(matrix);
		System.out.println(res);
	}
}
