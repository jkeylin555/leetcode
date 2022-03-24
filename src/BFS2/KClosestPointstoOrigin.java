package BFS2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Points> pQueue =  new PriorityQueue<>(new Comparator<Points>() {
			@Override
			public int compare (Points p1, Points p2) {
				if (p1.distance == p2.distance) return 0;
				return p1.distance > p2.distance ? -1 : 1;
			}
		});
		for (int i = 0; i < points.length; i++) {
			pQueue.offer(new Points(points[i][0], points[i][1]));
			if (i >= k) {
				pQueue.poll();
			}
		}
		int[][] res = new int[k][2];
        int i = 0;
		while (!pQueue.isEmpty()) {
			Points p = pQueue.poll();
			res[i][0] = p.x;
			res[i][1] = p.y;
			i++;
		}
		return res;
	}
	private class Points {
		int x, y;
		double distance;
		private Points(int x, int y) {
			this.x = x;
			this.y = y;
			this.distance = Math.pow(x, 2) + Math.pow(y, 2);
		}
	}

	public static void main(String[] args) {
		int[][] A = {{-5,4}, {-6,-5}, {4,6}};
		KClosestPointstoOrigin kClosestPointstoOrigin = new KClosestPointstoOrigin();
		int[][] result = kClosestPointstoOrigin.kClosest(A,2);
		System.out.println(result);
	}
}
