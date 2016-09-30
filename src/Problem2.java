import java.util.ArrayList;

public class Problem2 {
	
	public static void main(String arg[]) {
		problem2();
	}
	
	public static void problem2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int result = 0, i = 0, fib = 1;

		while (fib < 4000000) {
			list.add(fib);
			if (i != 0) {
				fib = fib + list.get(i - 1);
				if (fib % 2 == 0) {
					result = result + fib;
				}
			}
			i++;
		}
		System.out.println(result);
	}

}
