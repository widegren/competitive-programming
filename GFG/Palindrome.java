package gfg;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		// One by one run for all input test cases
		while (t > 0) {
			int nr = sc.nextInt();

			// Compute and print result
			System.out.println(search(nr, (int)(Math.log10(nr)+1)));

			t--;
		}
		sc.close();
	}

	public static String search(int nr, int length) {
		int[] array = new int[length];
		for(int i = 0 ; nr > 0; i++,nr=nr/10){
			array[i] = nr%10;
		}
		for(int i = 0; i < length; i++){
			if(array[i] != array[length-1-i]){
				return "No";
			}
		}
		return "Yes";
	}
}
