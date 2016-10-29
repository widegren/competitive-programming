package gfg;

import java.util.Hashtable;
import java.util.Scanner;

public class SegmentDisplay {
	static Hashtable<Integer, Integer> hm = new Hashtable<Integer, Integer>();
	static int[] array = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 5 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			String str = sc.next();
			char[] chArr = str.toCharArray();

			int tot = 0;
			for (Character c : chArr) {
				tot += array[Character.getNumericValue(c)];
			}
			System.out.println(getMaximum(initialize(array), n, tot));
			t--;
		}
		sc.close();
	}

	static String getMaximum(Hashtable<Integer, Integer> hm, int n, int tot) {
		String res = "";

		int tmp = tot, nr = 0;

		while (tmp > 0 && nr < n) {
			if(tmp/7 == n){
				for(int i = 0; i < n; i++){
					res += "8";
				}
				tmp = 0;
				break;
			}
			else if (tmp >= 6 && (tmp - 6) / 2 >= (n - nr - 1) && n > 1) {
				res += "0";
				nr++;
				tmp -= 6;
			} else if (nr < n - 1 && (tmp - 2) / 2 >= (n - nr - 1) && n > 1) {
				res += "1";
				nr++;
				tmp -= 2;
			} else {
				if (tmp > 9) {
					res += hm.get(tmp / n);
					tmp -= tmp / n;
				} else {
					res += hm.get(tmp);
					tmp -= tmp;
				}
				nr++;
			}
		}
		return res;
	}

	public static Hashtable<Integer, Integer> initialize(int[] array) {
		int j = 0;
		for (int i : array) {
			if (!hm.containsKey(i))
				hm.put(i, j);
			j++;
		}
		return hm;
	}
}
