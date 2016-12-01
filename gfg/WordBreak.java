package gfg;

import java.util.*;

public class WordBreak {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			Set<String> set = new HashSet<String>();
			for (int i = 0; i < n; i++) {
				set.add(sc.next());
			}
			String str = sc.next();
			@SuppressWarnings("unchecked")
			ArrayList<String>[] pos = new ArrayList[str.length() + 1];
			pos[0] = new ArrayList<String>();
			for (int i = 0; i < str.length(); i++) {
				for (int j = i + 1; j <= str.length(); j++) {
					String sub = str.substring(i, j);
					if (set.contains(sub)) {
						if (pos[j] == null) {
							ArrayList<String> list = new ArrayList<String>();
							list.add(sub);
							pos[j] = list;
						} else {
							pos[j].add(sub);
						}
					}
				}
			}
			if (pos[str.length()] == null) {
				System.out.println("Empty");
			} else {
				ArrayList<String> result = new ArrayList<String>();
				dfs(pos, result, "", str.length());
				Collections.sort(result);
				for (String s : result) {
					System.out.print("(" + s + ")");
				}
			}
			System.out.println();
			t--;
		}
		sc.close();
	}

	public static void dfs(ArrayList<String>[] pos, ArrayList<String> result, String curr, int i) {
		if (i == 0) {
			result.add(curr.trim());
			return;
		}

		for (String s : pos[i]) {
			String combined = s + " " + curr;
			dfs(pos, result, combined, i - s.length());
		}
	}
}
