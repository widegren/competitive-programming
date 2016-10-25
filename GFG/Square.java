package gfg;

import java.awt.Point;
import java.util.Scanner;

public class Square {
	public static void main(String[] args) {
		Point[] arr = new Point[4];

		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		// One by one run for all input test cases
		while (t > 0) {
			// Input the array
			for (int i = 0; i < 4; i++) {
				arr[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			// Compute and print result
			System.out.println((search(arr) == true) ? "1" : "0");

			t--;
		}
		sc.close();
	}

	public static boolean search(Point[] array) {
		Point p1 = array[0], p2 = array[1], p3 = array[2], p4 = array[3];

		int d2 = distSq(p1, p2); // from p1 to p2
		int d3 = distSq(p1, p3); // from p1 to p3
		int d4 = distSq(p1, p4); // from p1 to p4

		if (d2 == d3 && 2 * d2 == d4) {
			int d = distSq(p2, p4);
			return (d == distSq(p3, p4) && d == d2);
		}
		if (d3 == d4 && 2 * d3 == d2) {
			int d = distSq(p2, p3);
			return (d == distSq(p2, p4) && d == d3);
		}
		if (d2 == d4 && 2 * d2 == d3) {
			int d = distSq(p2, p3);
			return (d == distSq(p3, p4) && d == d2);
		}

		return false;
	}

	private static int distSq(Point p1, Point p2) {
		return ((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
	}
}
