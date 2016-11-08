import java.math.BigInteger;

public class Problem3 {
	public static void main(String arg[]) {
		problem3();
	}

	public static void problem3() {
		BigInteger num = new BigInteger("600851475143");
		BigInteger factors;
		int i = 2;
		BigInteger k = new BigInteger("2");
		while (BigInteger.valueOf(i).compareTo(num) < 0) {
			factors = num.mod(k);
			if (BigInteger.valueOf(0).compareTo(factors) == 0 && isPrime(i)) {
				System.out.println(i);
			}
			i++;
			k = k.add(BigInteger.ONE);
		}
	}

	public static boolean isPrime(int n) {
		if (n % 2 == 0 && n != 2)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
