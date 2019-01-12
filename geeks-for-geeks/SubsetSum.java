package gfg;

import java.util.Scanner;

public class SubsetSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int[] array = new int[n];
			
			for(int i = 0 ; i < n ; i++){
				array[i] = sc.nextInt();
			}

			if (subset(array)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

			t--;
		}
		sc.close();
	}

	static boolean subset(int array[]) {
		int sum = 0;
		int i, j;

		// Caculcate sun of all elements
		for (i = 0; i < array.length; i++)
			sum += array[i];

		if (sum % 2 != 0)
			return false;

		boolean part[][] = new boolean[sum / 2 + 1][array.length + 1];

		// initialize top row as true
		for (i = 0; i <= array.length; i++)
			part[0][i] = true;

		// initialize leftmost column, except part[0][0], as 0
		for (i = 1; i <= sum / 2; i++)
			part[i][0] = false;

		// Fill the partition table in botton up manner
		for (i = 1; i <= sum / 2; i++) {
			for (j = 1; j <= array.length; j++) {
				part[i][j] = part[i][j - 1];
				if (i >= array[j - 1])
					part[i][j] = part[i][j] || part[i - array[j - 1]][j - 1];
			}
		}

		/*
		 * // uncomment this part to print table for (i = 0; i <= sum/2; i++) {
		 * for (j = 0; j <= n; j++) printf ("%4d", part[i][j]); printf("\n"); }
		 */

		return part[sum / 2][array.length];
	}
}
