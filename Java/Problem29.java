import java.util.*;

public class Problem29 {
	public static void main(String[] args) {
		HashSet<Double> set = new HashSet<Double>();
		for (int i = 2; i < 101; i++) {
			for (int j = 2; j < 101; j++) {
				set.add(Math.pow(i, j));
			}
		}
		System.out.println(set.size());
	}
}
