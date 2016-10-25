package gfg;

import java.util.Scanner;

public class SecondLargest {
	public static void main(String[] args) {
		int[] arr = new int[500];

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
			System.out.println(search(arr, n));

			t--;
		}
		sc.close();
	}

	public static String search(int[] array, int n) {
		int secondlargest = -1;
		int largest = -1;
		for (int i = 0; i < n; i++) {
			if(array[i] > largest){
				secondlargest = largest;
				largest = array[i];
			}
			else if(array[i] > secondlargest){
				secondlargest = array[i];
			}
		}
		return Integer.toString(secondlargest);
	}
}
