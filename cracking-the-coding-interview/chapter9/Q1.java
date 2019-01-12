package Chapter9;

/**
 * 
 * @author emeliewidegren
 *
 *         A child is running up a staircase with n steps, and can hop either 1
 *         step, 2 steps, or 3 steps at a time. Implement a method to count how
 *         many possible ways the child can run up the stairs.
 */
public class Q1 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(countWaysRecursive(n));
		System.out.println(countWaysDP(n));

	}

	public static int countWaysDP(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

	public static int countWaysRecursive(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
		}
	}
}