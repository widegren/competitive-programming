package gfg;

import java.util.Scanner;

public class Minimum_Sub_Partition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int[] array = new int[n];

			for (int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}
			System.out.println(minimumSum(array, n));
			t--;
		}
		sc.close();
	}

	static int minimumSum(int[] array, int n) {
		int sum = 0;

		for (int c : array) {
			sum += c;
		}
		
		boolean[][] L = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++)
			L[i][0] = true;

		for (int i = 1; i <= sum; i++)
			L[0][i] = false;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				
				// If i'th element is excluded
				L[i][j] = L[i - 1][j];

				// If i'th element is included
				if (array[i - 1] <= j)
					L[i][j] |= L[i - 1][j - array[i - 1]];
			}
		}

		// Initialize difference of two sums.
		int diff = Integer.MAX_VALUE;

		// Find the largest j such that dp[n][j]
		// is true where j loops from sum/2 t0 0
		for (int j = sum / 2; j >= 0; j--) {
			// Find the
			if (L[n][j] == true) {
				diff = sum - 2 * j;
				break;
			}
		}
		return diff;
	}
}
