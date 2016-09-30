
public class Problem5 {
	
	public static void main(String arg[]) {
		problem5();
	}
	
	public static void problem5() {
		for (int i = 20;; i++) {
			if (divisible(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	public static boolean divisible(int n) {
		for (int k = 20; k > 0; k--) {
			if (n % k == 0)
				continue;
			else
				return false;
		}
		return true;
	}
}
