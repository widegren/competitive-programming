package gfg;

import java.util.Scanner;

public class InterLeaveString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			String a = sc.next();
			String b = sc.next();
			String c = sc.next();

			System.out.println(isInterLeave(a, b, c) == true ? 1 : 0);
			t--;
		}
		sc.close();
	}

	private static boolean isInterLeave(String a, String b, String c) {
		if (a.length() == 0 && b.length() == 0 && c.length() == 0) {
			return true;
		}
		if (c.length() == 0) {
			return false;
		} else if (a.length() == 0) {
			return (b.charAt(0) == c.charAt(0) && isInterLeave(a, b.substring(1), c.substring(1)));
		} else if (b.length() == 0) {
			return (a.charAt(0) == c.charAt(0) && isInterLeave(a.substring(1), b, c.substring(1)));
		} else {
			return (a.charAt(0) == c.charAt(0) && isInterLeave(a.substring(1), b, c.substring(1))
					|| (b.charAt(0) == c.charAt(0) && isInterLeave(a, b.substring(1), c.substring(1))));
		}
	}
}
