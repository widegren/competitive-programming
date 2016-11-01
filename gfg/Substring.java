package gfg;

import java.util.Scanner;

public class Substring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			String str1 = sc.next();
			String str2 = sc.next();

			if (length(str1, str2) == str2.length()) {

			}

			t--;
		}
	}

	static int length(String str1, String str2) {
		int[][] L = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;

				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					L[i][j] = L[i - 1][j - 1] + 1;

				else
					L[i][j] = max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[str1.length()][str2.length()];
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
