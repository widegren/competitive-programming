package gfg;

import java.util.*;

public class NextLarger {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				boolean larger = false;
				for (int j = i; j < n; j++) {
					if (array[j] > array[i]) {
						larger = true;
						System.out.print(array[j] + " ");
						break;
					}
				}
				if (!larger)
					System.out.print(-1 + " ");
			}
			System.out.println();
			t--;
		}
		sc.close();
	}
}
