
public class Problem9 {
	public static void main(String arg[]) {
		problem9();
	}

	public static void problem9() {
		System.out.println(pythagorean());
	}

	public static int pythagorean() {
		for (int a = 1;; a++) {
			for (int b = 1;; b++) {
				double c = a * a + b * b;
				c = Math.sqrt(c);
				double tot = a + b + c;
				double prod = a * b * c;
				if (tot == 1000) {
					return (int) prod;
				}
				if (tot > 1000)
					break;
			}
		}
	}
}
