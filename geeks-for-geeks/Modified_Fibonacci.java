package gfg;

import java.util.Scanner;

public class Modified_Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			long[] fib = new long[6];
			long A = (long) sc.nextInt();
			long B = (long) sc.nextInt();
			long C = (long) sc.nextInt();

			fib[0] = A + B;
			fib[1] = B + C;

			for (int i = 2; i < 6; i++) {
				fib[i] = fib[i - 1] - fib[i - 2];
			}
			long f = fib[(int) ((n - 1) % 6)];
			while (f < 0)
				f = f + 1000000007;
			System.out.println(f % 1000000007);

			t--;
		}
		sc.close();
	}
}
