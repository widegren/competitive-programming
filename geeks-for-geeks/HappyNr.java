package gfg;

import java.util.Scanner;

public class HappyNr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int tries = 0;
			while (n > 1 && tries < 10) {
				int tmp = n, newnr = 0;
				while (tmp > 0) {
					int nr = tmp % 10;
					newnr += nr * nr;
					tmp = tmp / 10;
				}
				n = newnr;
				tries++;
			}
			if (n == 1)
				System.out.println(n);
			else
				System.out.println("0");
			t--;
		}
		sc.close();
	}
}
