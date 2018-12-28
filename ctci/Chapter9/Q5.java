package Chapter9;

import java.util.*;

/**
 * 
 * @author emeliewidegren
 *
 *         Write a method to compute all permutations of a string.
 */
public class Q5 {
	public static void main(String[] args) {
		String str = "emelie";
		List<String> list = getPermutations(str);
		for(String s : list)
			System.out.println(s);
		System.out.println(list.size());
	}

	public static List<String> getPermutations(String str) {
		if (str == null) {
			return null;
		}
		List<String> per = new ArrayList<String>();
		per.add(str.substring(0, 1));
		for (int i = 1; i < str.length(); i++) {
			List<String> curr = new ArrayList<String>();
			char c = str.charAt(i);
			for (String s : per) {
				for (int j = 0; j <= s.length(); j++) {
					curr.add(s.substring(0, j) + c + s.substring(j));
				}
			}
			per = curr;
		}
		return per;
	}
}
