package laioffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapExercise {

	static class Coordinate {
		int x, y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "(" + x +", " + y + ")";
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Coordinate)) {
				return false;
			}
			Coordinate coordinate = (Coordinate) obj;
			return this.x == coordinate.x && this.y == coordinate.y;
		}

		@Override
		public int hashCode() {
			return x * 100 + y;
		}
	}
	public static void main(String[] args){
		Map<Coordinate, Integer> map = new HashMap<Coordinate, Integer>();
		Map<String, Integer> map2 = new HashMap<>();
		Coordinate c1 = new Coordinate(1, 2);
		Coordinate c2 = new Coordinate(1, 2);
		map.put(c1, 5);
		map.put(c2, 6);
		map2.put("a", 1);
		map2.put("b", 2);
		System.out.println(map.toString());
		System.out.println(map.toString());
	}



//	public static void main(String[] args){
//		Map<Coordinate, Integer> map = new HashMap<Coordinate, Integer>();
//		Map<String, Integer> map2 = new HashMap<>();
//		Coordinate c1 = new Coordinate(1, 2);
//		Coordinate c2 = new Coordinate(1, 2);
//		map.put(c1, 5);
//		map.put(c2, 6);
//		map2.put("a", 1);
//		map2.put("b", 2);
////		System.out.println(map.toStringTT());
//		System.out.println(map.toString());
//		System.out.println(c1 == c2);
//		System.out.println(c1.equals(c2));
//		System.out.println("a".equals("a"));
//		Integer a = 1;
//		Integer b = 1;
//		System.out.println(a.equals(b));
////		Set<Integer> set = new HashSet<>();
//////		System.out.println(set.add(1));
//////		System.out.println(set.add(2));
//////		System.out.println(set.add(1));
////		for (String key: map2.keySet()) {
////			System.out.println(key + map2.get(key));
////		}
////		System.out.println(map2);
////		for (Coordinate key: map.keySet()) {
////			System.out.println(key.toString() + map.get(key));
////		}
//
//	}


}


//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Coordinate)) {
//			return false;
//		}
//		Coordinate coordinate = (Coordinate) obj;
//		return this.x == coordinate.x && this.y == coordinate.y;
//	}
//	@Override
//	public int hashCode() {
//		return x * 100 + y;
//	}
