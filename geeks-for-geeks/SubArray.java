package gfg;

import java.util.Scanner;

/**
 * 
 * @author emeliewidegren
 *
 *         Given an unsorted array of non-negative integers, find a continous
 *         subarray which adds to a given number.
 *         http://www.practice.geeksforgeeks.org/problem-page.php?pid=590
 * 
 */
public class SubArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			int[] array = new int[n];

			for (int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}

			System.out.println(findSubArray(array, sum));
			t--;
		}
		sc.close();
	}

	static String findSubArray(int[] array, int sum) {
		int result = 0, start = 0;

		for (int i = 0; i < array.length; i++) {
			result += array[i];
			if (result == sum) {
				return start + 1 + " " + ++i;
			} else if (result > sum) {
				while (result > sum) {
					result -= array[start];
					start++;
				}
				if (result == sum) {
					return start + 1 + " " + ++i;
				}
			}
		}
		return "-1";
	}
}
