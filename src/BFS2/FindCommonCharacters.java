package BFS2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
	public List<String> commonChars(String[] words) {
		List<String> res  = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : words[0].toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int i = 1; i < words.length; i++) {
			Map<Character, Integer> temp = new HashMap<>();
			for (char c : words[i].toCharArray()) {
				temp.put(c, temp.getOrDefault(c, 0) + 1);
			}
			for (char c : map.keySet()) {
				if (!temp.containsKey(c)) {
					map.put(c, 0);
				} else {
					map.put(c, Math.min(map.get(c), temp.get(c)));
				}
			}
		}
		for (char c : map.keySet()) {
			int count = map.get(c);
			while (count > 0) {
				res.add(Character.toString(c));
				count--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] str = {"bella","label","roller"};
		FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
		List<String> result = findCommonCharacters.commonChars(str);
		System.out.println(result);
	}
}
