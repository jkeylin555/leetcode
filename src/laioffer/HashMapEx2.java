package laioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HashMapEx2 {
	static class ListNode {
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value = value;
			this.next = null;
		}
	}
	static class HashMap {
		ListNode listNode = new ListNode(4);
		ListNode[] hashmap;
		int size;
		public HashMap(int size) {
			this.size = size;
		}
		public int size() {
			return this.size;
		}
		public ListNode[] clear() {
			this.hashmap = new ListNode[0];
			return hashmap;

		}
	}
	static public class Box<T> {
		// T stands for "Type"
		private T t;

		public void set(T t) { this.t = t; }
		public T get() { return t; }
//		public void add(Integer integer) {
//
//		}
	}

	static public class A {
		public String show(D obj) {
			return ("A and D");
		}
		public String show(A obj) {
			return "A and A";
		}
	}
	static public class B extends A {
		public String show(B obj) {
			return "B and B";
		}
		public String show(A obj) {
			return "B and A";
		}
	}
	static public class C extends B {}
	static public class D extends B {}

	public static void main(String[] args) {

		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println(a1.show(b));
		System.out.println(a1.show(c));
		System.out.println(a1.show(d));
		System.out.println(a2.show(b));
		System.out.println(a2.show(c));
		System.out.println(a2.show(d));
		System.out.println(b.show(b));
		System.out.println(b.show(c));
		System.out.println(b.show(d));
		HashMap hashMap = new HashMap(6);
		System.out.println(hashMap.size);
		System.out.println(hashMap.size());
		Box<Integer> box = new Box<Integer>();
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();
		List<Integer> integerList = new ArrayList<>();
//		for (int i = 0; i < 10; i++){
//			integerList.add(Integer.valueOf(i));
//			System.out.println(integerList.get(i).intValue());
//		}
//		Integer aa1 = 12;
		Integer c1 = 12;
		Integer aa = 129;
		Integer cc = 129;
		System.out.println(aa > c1);
		System.out.println(aa >= c1);
		System.out.println(aa <= c1);
		System.out.println(aa == c1);
		System.out.println(aa.equals(c1));
		System.out.println(aa == c1);

//		integerBox.add(new Integer(10));
//		stringBox.add(new String("泛型测试"));
		System.out.println((-4) & 0x7FFFFFFF);
		System.out.println(-1 & Integer.MAX_VALUE);
		System.out.println(-1111&Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE - 1);
		System.out.println((int)(Math.pow(2, 28) + 1)<<4);
//		hashMap = hashMap.clear();
//		System.out.println(hashMap.size);
//		for<Map.Entry<String, Integer> entry: hashMap.

		char[] array = {'a', 'b', 'c', 'd'};
		System.out.println(array[1]);
		StringBuilder stringBuilder = new StringBuilder("abc");
		stringBuilder.append("a");
		String str = "abcd";
		char[] strArray = str.toCharArray();
		System.out.println(stringBuilder.toString());
		System.out.println(strArray);  

	}
}
