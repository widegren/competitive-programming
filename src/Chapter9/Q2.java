package Chapter9;

/**
 * 
 * @author emeliewidegren
 *
 *         Imagine a robot sitting on the upper left corner of an X by Y grid.
 *         The robot can only move in two directions: right and down. How many
 *         possible paths are there for the robot to go from (0,0) to (X,Y)?
 */
public class Q2 {
	public static void main(String[] args) {
		System.out.println(getPath(5, 4));
		System.out.println(getPathDP(5, 4));
	}

	public static int getPath(int x, int y) {
		int tmp1 = x + y;
		int tmp2 = y;

		for (int i = 1; i < y; i++) {
			tmp2 *= (y - i);
			tmp1 *= ((x + y) - i);
		}
		int result = tmp1 / tmp2;
		return result;
	}

	public static int getPathDP(int x, int y) {
		int[][] dp = new int[x + 1][y + 1];

		for (int i = 0; i <= x; i++) {
			dp[i][0] = 1;
		}

		for (int i = 0; i <= y; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[x][y];
	}
}