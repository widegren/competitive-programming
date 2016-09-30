
public class Problem1 {
	
	public static void main(String arg[]) {
		problem1();
	}
	
	public static void problem1() {
		int result = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				result = result + i;
			}
		}
		System.out.println(result);
	}
}
