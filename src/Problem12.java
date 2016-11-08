public class Problem12 {
	public static void main(String arg[]) {
		problem12();
	}

	public static void problem12() {
		long res = 1;
		long k = 2;
		while (divisible(res) <= 500) {
			res += k;
			k++;
		}
		System.out.println(res);
	}

	public static long divisible(long number) {
		long divisors = 0;
		for (long i = 1; i * i <= number; i++) {
			if (number % i == 0) {
				if (i * i < number) {
					divisors += 2; // i and number/i are (different) divisors
				} else {
					divisors += 1; // i == number/i is a divisor
				}
			}
		}
		return divisors;
	}
}
