public class Problem10 {

	public static void main(String arg[]) {
		problem10();
	}

	public static void problem10() {
		long res = 0;
		for (int i = 2; i < 2000000; i++) {
			if (Problem3.isPrime(i)) {
				res = res + i;
			}
		}
		System.out.println(res);
	}
}
