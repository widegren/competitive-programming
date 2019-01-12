package gfg;

import java.util.Scanner;

public class RemoveFromString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			String str = sc.next();
			String result = "";
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'b') {

				} else if (str.charAt(i) == 'a') {
					if (i != str.length() - 1 && str.charAt(i + 1) == 'c') {
						i++;
					} else {
						result += str.charAt(i);
					}
				} else {
					result += str.charAt(i);
				}
			}
			System.out.println(result);
			t--;
		}
		sc.close();
	}
}
