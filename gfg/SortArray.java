package gfg;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int[] array = new int[n];
			Arrays.fill(array, -1);
			int start = 0, end = n - 1;
			for (int i = 0; i < n; i++) {
				int j = sc.nextInt();
				if (j == 0) {
					array[start] = 0;
					start++;
				}
				if (j == 2) {
					array[end] = 2;
					end--;
				}
			}
			for (int i = 0; i < n; i++) {
				if (array[i] == -1)
					array[i] = 1;
				System.out.print(array[i] + " ");
			}
			System.out.println();
			t--;
		}
		sc.close();
	}
}
