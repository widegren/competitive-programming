import java.math.BigInteger;

public class Problem20 {
	public static void main(String arg[]) {
		problem20();
	}

	public static void problem20() {
		BigInteger result = BigInteger.ONE;
		for (int i = 100; i > 0; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		int res = 0;
		String str = String.valueOf(result);
		for (int i = 0; i < str.length(); i++) {
			res = res + Character.getNumericValue(str.charAt(i));
		}
		System.out.println(res);
	}
}
