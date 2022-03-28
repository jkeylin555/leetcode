package DP;

import DFS.Subsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TrappingRainWater {
	public int trap(int[] height) {
		int[] leftMaxArray = new int[height.length];
		int[] rightMaxArray = new int[height.length];
		leftMaxArray[0] = height[0];
		rightMaxArray[height.length - 1] = height[height.length - 1];
		int result = 0;
		for (int i = 1; i < height.length; i++) {
			leftMaxArray[i] = Math.max(leftMaxArray[i - 1], height[i]);
		}
		for (int i = height.length - 2; i >= 0; i--) {
			rightMaxArray[i] = Math.max(rightMaxArray[i + 1], height[i]);
		}

		for (int i = 0; i < height.length; i++) {
			int lrHeight = Math.min(leftMaxArray[i], rightMaxArray[i]);
			int curRain = lrHeight - height[i];
			result += curRain;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] duNums = {0,1,0,2,1,0,1,3,2,1,2,1};
       	TrappingRainWater trappingRainWater = new TrappingRainWater();
		System.out.println(trappingRainWater.trap(duNums));
	}
}
