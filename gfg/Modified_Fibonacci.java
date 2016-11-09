package gfg;

import java.util.Scanner;

public class Modified_Fibonacci {
	public static void main(String[] args ){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
			int n = sc.nextInt();
			int[] fib = new int[n+1];
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			
			fib[1] = A+B;
			fib[2] = B+C;
			
			for(int i = 3; i <= n ; i++){
				fib[i] = fib[i-1] - fib[i-2];
			}
			System.out.println(fib[n] % 1000000007);
			t--;
		}
		sc.close();
	}
}
