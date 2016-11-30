package gfg;

import java.util.*;

/**
 * 
 * @author emeliewidegren
 *
 *         2 4 7 OOOOXXO OXOXOOX XXXXOXO OXXXOOO 10 3 XXO OOX OXO OOO XOX XOX
 *         OXO XXO XXX OOO
 */
public class XTotalShapes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int rows = sc.nextInt();
			int columns = sc.nextInt();
			char[][] matrix = new char[rows][columns];
			boolean[][] visited = new boolean[rows][columns];
			for (int i = 0; i < rows; i++) {
				String str = sc.next();
				for (int j = 0; j < columns; j++) {
					matrix[i][j] = str.charAt(j);
					visited[i][j] = false;
				}
			}
			int result = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					if (matrix[i][j] == 'X' && !visited[i][j]) {
						check(rows, columns, i, j, matrix, visited);
						result++;
					}
				}
			}
			System.out.println(result);
			t--;
		}
		sc.close();
	}

	static void check(int n, int m, int i, int j, char[][] ar, boolean[][] visited) {
		if (ar[i][j] == 'X' && !visited[i][j]) {
			visited[i][j] = true;
			if (i + 1 < n) {
				check(n, m, i + 1, j, ar, visited);
			}
			if (i - 1 >= 0) {
				check(n, m, i - 1, j, ar, visited);
			}
			if (j + 1 < m) {
				check(n, m, i, j + 1, ar, visited);
			}
			if (j - 1 >= 0) {
				check(n, m, i, j - 1, ar, visited);
			}
		}
	}
}
