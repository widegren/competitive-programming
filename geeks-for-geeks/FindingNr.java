package gfg;

import java.util.*;

public class FindingNr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt() * 2 + 2;
			TreeSet<Integer> set = new TreeSet<Integer>();
			for (int i = 0; i < n; i++) {
				int j = sc.nextInt();
				if (!set.contains(j)) {
					set.add(j);
				} else {
					set.remove(j);
				}
			}
			for (int i : set) {
				System.out.print(i + " ");
			}
			System.out.println();
			t--;
		}
		sc.close();
	}
}
