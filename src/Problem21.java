
public class Problem21 {
	public static void main(String arg[]) {
		problem21();
	}

	public static void problem21() {
		int result = 0;
		for (int i = 0; i < 10000; i++) {
			int nr = amicable(i);
			if (amicable(nr) == i && nr != i) {
				result += i;
			}
		}
		System.out.println(result);
	}

	public static int amicable(int nr) {
		int result = 0;
		for (int i = 1; i < nr; i++) {
			if (nr % i == 0) {
				result += i;
			}
		}
		return result;
	}
}
