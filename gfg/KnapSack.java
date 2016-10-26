package gfg;

import java.util.Scanner;

public class KnapSack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int W = sc.nextInt();

			int[] val = new int[n];
			int[] wt = new int[n];

			for (int i = 0; i < n; i++) {
				val[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				wt[i] = sc.nextInt();
			}
			System.out.println(getMax(val, wt, W));
			t--;
		}
		sc.close();
	}

	static int getMax(int[] val, int[] wt, int W) {
		int i, w;
		int K[][] = new int[val.length + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= val.length; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[val.length][W];
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}