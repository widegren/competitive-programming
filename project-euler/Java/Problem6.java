
public class Problem6 {

	public static void main(String arg[]) {
		problem6();
	}

	public static void problem6() {
		int res = 0, res1 = 0, square;
		for (int i = 1; i < 101; i++) {
			res = res + i * i;
			res1 = res1 + i;
		}
		res1 = res1 * res1;
		square = res1 - res;
		System.out.println(square);
	}
}
