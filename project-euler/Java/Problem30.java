
public class Problem30 {
	public static void main(String[] args) {
		int result = 0, n = 5;
		for (int i = 2; i < 200000; i++) {
			int sum = 0, number = i;
			while (number > 0) {
				sum += Math.pow(number % 10, n);
				number = number / 10;
			}
			if (sum == i) {
				result += i;
			}
		}
		System.out.println(result);
	}
}
