package gfg;

import java.util.Scanner;

class LRU_Cache {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			LRUCache g = new LRUCache(n);
			int q = sc.nextInt();

			while (q > 0) {

				String c = sc.next();
				// System.out.println(c);
				if (c.equals("GET")) {
					int x = sc.nextInt();
					System.out.print(g.get(x) + " ");
				}
				if (c.equals("SET")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					g.set(x, y);
				}

				q--;
				// System.out.println();
			}
			t--;
			System.out.println();
		}
		sc.close();
	}
}

/* You are required to complete below class */
class LRUCache {
	int[] array;
	java.util.LinkedList<Integer> list;
	int current = 0, size = 0;

	/* Inititalize an LRU cache with size N */
	public LRUCache(int N) {
		// Your code here
		array = new int[1000];
		list = new java.util.LinkedList<Integer>();
		size = N;
	}

	/*
	 * Returns the value of the key x if present else returns -1
	 */
	public int get(int x) {
		// Your code here
		if (array[x] != 0) {
			list.removeFirstOccurrence(x);
			list.add(x);
			return array[x];
		}
		return -1;
	}

	/* Sets the key x with value y in the LRU cache */
	public void set(int x, int y) {
		if (current >= size && array[x] == 0) {
			int i = list.remove();
			array[i] = 0;
			current--;
		}
		if (current >= size && array[x] != 0) {
			list.removeFirstOccurrence(x);
			list.add(x);
			array[x] = y;
		}
		if (current < size && array[x] == 0) {
			array[x] = y;
			list.removeFirstOccurrence(x);
			list.add(x);
			current++;
		}
		if (current < size && array[x] != 0) {
			array[x] = y;
			list.removeFirstOccurrence(x);
			list.add(x);
		}
	}
}
