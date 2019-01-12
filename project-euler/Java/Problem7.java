
public class Problem7 {
	public static void main(String arg[]) {
		problem7();
	}

	public static void problem7() {
		int nr = 0;
		for (int i = 2;; i++) {
			if (Problem3.isPrime(i)) {
				nr++;
			}
			if (nr == 10001) {
				System.out.println(i);
				break;
			}
		}
	}
}
