package GFG;

import java.util.Scanner;

public class Longest_Common_Subsequence {
	public static void main(String[] args) {
		String[] list = new String[1000];
		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		// One by one run for all input test cases
		int i = 0;
		while (t > 0) {
			// Input the size of the array
			int len1 = sc.nextInt();
			int len2 = sc.nextInt();

			String str1 = sc.next();
			list[i] = str1;
			String str2 = sc.next();
			list[i + 1] = str2;
			i += 2;

			t--;
		}
		sc.close();

		for (int j = 0; j < i; j += 2) {
			// Compute and print result
			System.out.println(length(list[j], list[j + 1]));
		}
	}

	static int length(String str1, String str2) {
		int[][] L = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0 || j == 0)
			         L[i][j] = 0;
			  
			       else if (str1.charAt(i-1) == str2.charAt(j-1))
			         L[i][j] = L[i-1][j-1] + 1;
			  
			       else
			         L[i][j] = max(L[i-1][j], L[i][j-1]);
			}
		}
		return L[str1.length()][str2.length()];
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
