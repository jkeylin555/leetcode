package exercise.FastSlowPointers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveDuplicates2 {
	public String removeDuplicates2 (String s) {

		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (stack.isEmpty() || stack.peek() != s.charAt(i) ) {
				stack.push(s.charAt(i));
			} else {
				stack.pop();
			}
		}
		String result = "";
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;


//		Stack<Character> stk = new Stack<>();
//		StringBuilder sb = new StringBuilder();
//		for(char c : s.toCharArray()){
//
//			if(!stk.isEmpty() && stk.peek().equals(c)){
//				stk.pop(); // if character is eequals to current char then pop
//			}else{
//				stk.push(c); // else push it
//			}
//		}
//
//		while(stk.size() > 0){
//			sb.insert(0, stk.pop()); // append the string with leftovers
//		}
//
//		return sb.toString();
//		if(string.length()==1)
//			return string;





	}


	public static void main(String[] args) {
		String str = "acccacb";
		Deque<Integer> queue = new ArrayDeque<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		RemoveDuplicates2 removeDuplicates2 = new RemoveDuplicates2();

		System.out.println(removeDuplicates2.removeDuplicates2(str));

	}
}
