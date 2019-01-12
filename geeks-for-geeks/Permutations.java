package gfg;

import java.util.Scanner;

public class Permutations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			String str = sc.next();
			permutation("", str);
			t--;

		}
		sc.close();
	}

	public static void permutation(String prefix, String s) {
		int n = s.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
		}

	}
}
