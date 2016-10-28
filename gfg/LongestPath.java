package gfg;

import java.util.LinkedList;
import java.util.Scanner;

public class LongestPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			LinkedList<Integer> adj[] = new LinkedList[n];

			for (int i = 0; i < n; ++i) {
				adj[i] = new LinkedList<Integer>();
			}

			int e = sc.nextInt();

			for (int i = 0; i < e; i++) {
				int node1 = sc.nextInt() - 1;
				int node2 = sc.nextInt() - 1;
				int w = sc.nextInt();
				adj[node1].add(w);
				adj[node2].add(w);
			}
			t--;
		}
		sc.close();
	}
}
