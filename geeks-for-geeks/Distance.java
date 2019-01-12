package gfg;

import java.util.Scanner;

public class Distance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();

			System.out.println(findMin(n));
			t--;
		}
		sc.close();
	}

	static int findMin(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

		return dp[n];
	}
}
