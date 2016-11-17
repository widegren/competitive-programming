package gfg;

import java.util.*;

public class NonRepeating {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			char res = 0;
			ArrayList<Character> set = new ArrayList<Character>();
			HashSet<Character> duplicates = new HashSet<Character>();
			String str = sc.next();
			for (int i = 0; i < n; i++) {
				char c = str.charAt(i);
				if (!set.contains(c)) {
					set.add(c);
				} else {
					duplicates.add(c);
				}
			}
			for (Character c : set) {
				if (!duplicates.contains(c)) {
					res = c;
					break;
				}
			}
			if (res != 0)
				System.out.println(res);
			else
				System.out.println(-1);
			t--;
		}
		sc.close();
	}
}
