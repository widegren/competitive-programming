package gfg;

import java.util.Scanner;

public class Longest_Increasing_Subsequence {
	public static void main(String[] args) {
		int[] array = new int[1000];
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}
			System.out.println(longestIncreasing(array, n));
			t--;
		}
	}

	static int longestIncreasing(int[] array, int n) {
		int[] result = new int[n];
		int max = 0;

		/* Initialize LIS values for all indexes */
		for (int i = 0; i < n; i++){
			result[i] = 1;
		}

		/* Compute optimized LIS values in bottom up manner */
		for (int i = 1; i < n; i++){
			for (int j = 0; j < i; j++){
				if (array[i] > array[j] && result[i] < result[j] + 1){
					result[i] = result[j] + 1;
				}
			}
		}

		/* Pick maximum of all LIS values */
		for (int i = 0; i < n; i++){
			if (max < result[i]){
				max = result[i];
			}
		}
		return max;
	}
}
