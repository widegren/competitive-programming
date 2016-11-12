
public class Problem28 {
	public static void main(String[] args) {
		int n = 1001;
		int max = n * n;
		int row = n - 1, column = 0;
		int[][] matrix = new int[n][n];

		while (max > 0) {
			/* Top */
			for (int i = row; i >= column; i--) {
				matrix[column][i] = max;
				max--;
			}

			/* Left */
			for (int i = column + 1; i <= row; i++) {
				matrix[i][column] = max;
				max--;
			}

			/* Bottom */
			for (int i = column + 1; i <= row; i++) {
				matrix[row][i] = max;
				max--;
			}

			/* Right */
			for (int i = row - 1; i > column; i--) {
				matrix[i][row] = max;
				max--;
			}
			row--;
			column++;
		}
		int diagonal1 = 0, diagonal2 = n - 1, result = 0;
		for (int i = 0; i < n; i++) {
			result += matrix[i][diagonal1];
			result += matrix[i][diagonal2];
			diagonal1++;
			diagonal2--;
		}
		System.out.println(result - 1);
	}
}
