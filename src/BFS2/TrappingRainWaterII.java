package BFS2;

import Stack.MaximalRectangle;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TrappingRainWaterII {
	public int trapRainWater(int[][] heightMap) {
		Set<Pair> set = new HashSet<>();
		int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int maxHeight = 0;
		int res = 0;
		int[][] visited = new int[heightMap.length][heightMap[0].length];
		PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare (Pair p1, Pair p2) {
				if (p1 == p2) return 0;
				return p1.height < p2.height ? -1 : 1;
			}
		});

		for (int i = 0; i < heightMap.length; i++) {
			minHeap.offer(new Pair(i, 0,heightMap[i][0]));
			minHeap.offer(new Pair(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
		}
		for (int i = 0; i < heightMap[0].length; i++) {
			minHeap.offer(new Pair(0, i, heightMap[0][i]));
			minHeap.offer(new Pair(heightMap.length - 1, i, heightMap[heightMap.length - 1][i]));
		}
		while (!minHeap.isEmpty()) {
			Pair top = minHeap.poll();
			if (visited[top.x][top.y] == 1) {
				continue;
			}
			int storage = Math.max(0, maxHeight - top.height);
			res += storage;
			maxHeight = Math.max(maxHeight, top.height);
			visited[top.x][top.y] = 1;
			for (int[] direction : directions) {
				if (valid(top.x + direction[0], top.y + direction[1], heightMap)) {
					int x = top.x + direction[0];
					int y = top.y + direction[1];
					int h = heightMap[x][y];
					minHeap.offer(new Pair(x, y, h));
				}
			}
		}

		return res;
	}
	private boolean valid(int x, int y, int[][] height) {
		if (x > height.length - 1 || x < 0) {
			return false;
		}
		if (y > height[0].length - 1 || y < 0) {
			return false;
		}
		return true;
	}
	public class Pair {
		int x, y, height;
		public Pair(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height = height;
		}
	}

	public static void main(String[] args) {
		int A[][] = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
		TrappingRainWaterII trappingRainWaterII = new TrappingRainWaterII();

		System.out.println(trappingRainWaterII.trapRainWater(A));
	}
}
