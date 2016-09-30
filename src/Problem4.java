
public class Problem4 {
	
	public static void main(String arg[]) {
		problem4();
	}
	
	public static void problem4() {
		int prod, res = 0;
		for (int i = 10; i < 1000; i++) {
			for (int k = 10; k < 1000; k++) {
				prod = i * k;
				if (Integer.toString(prod).length() % 2 == 0) {
					if (isPalindrome(Integer.toString(prod)) && prod > res) {
						res = prod;
					}
				}
			}
		}
		System.out.println(res);
	}

	public static boolean isPalindrome(String s) {
		int l = s.length() - 1;
		for (int n = 0; l > n; l--, n++) {
			if (s.charAt(n) == s.charAt(l)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
