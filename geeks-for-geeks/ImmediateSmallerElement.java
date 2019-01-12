package gfg;

import java.util.Scanner;

public class ImmediateSmallerElement {
	public static void main(String[] args) {
		int[] arr = new int[1000];

		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		// One by one run for all input test cases
		while (t > 0) {
			// Input the size of the array
			int n = sc.nextInt();

			// Input the array
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			// Compute and print result
			System.out.println(smaller(arr, n));

			t--;
		}
		sc.close();
	}

	public static String smaller(int[] array, int n) {
		String str = "";
		for (int i = 0; i < n-1; i++) {
			if (array[i] > array[i+1]) {
				str += array[i+1] + " ";
			} else {
				str += "-1 ";
			}
		}
		return str += "-1";
	}
}
