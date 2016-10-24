package GFG;

import java.util.Scanner;

public class Edit_Distance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int str1len = sc.nextInt();
			int str2len = sc.nextInt();

			String str1 = sc.next();
			String str2 = sc.next();

			System.out.println(minimum(str1, str2));
			t--;
		}
		sc.close();
	}

	static int minimum(String str1, String str2) {
		int[][] L = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0) {
					L[i][j] = j;
				}
				else if(j == 0){
					L[i][j] = i;
				} else if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
					L[i][j] = 1 + min(L[i - 1][j], 	//Remove
							L[i][j - 1],			//Insert
							L[i-1][j-1]);			//Replace
				} else {
					L[i][j] = L[i - 1][j - 1];
				}
			}
		}
		return L[str1.length()][str2.length()];
	}

	private static int min(int a, int b, int c) {
		if(a < b && a< c) return a;
		if(b < c && b < a) return b;
		else return c;
	}

}