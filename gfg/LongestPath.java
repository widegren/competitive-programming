package gfg;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;

public class LongestPath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			@SuppressWarnings("unchecked")
			LinkedList<Hashtable<Integer, Integer>> adj[] = new LinkedList[n + 1];
			boolean[] visited = new boolean[n + 1];

			for (int i = 1; i <= n; i++) {
				adj[i] = new LinkedList<Hashtable<Integer, Integer>>();
				Hashtable<Integer, Integer> pairs = new Hashtable<Integer, Integer>();
				adj[i].add(pairs);
			}

			int e = sc.nextInt();

			for (int i = 1; i <= e; i++) {
				int node1 = sc.nextInt();
				int node2 = sc.nextInt();
				int w = sc.nextInt();
				adj[node1].get(0).put(node2, w);
				adj[node2].get(0).put(node1, w);
			}
			int max = 0;
			for (int i = 1; i <= n; i++) {
				Arrays.fill(visited, false);
				int tmp = findLongest(i, adj, visited, 0, 0);
				if (max < tmp) {
					max = tmp;
				}
			}

			System.out.println(max);
			t--;
		}
		sc.close();
	}

	static int findLongest(int node, LinkedList<Hashtable<Integer, Integer>>[] adj, boolean[] visited, int max,
			int prev) {
		int tmp = 0;
		visited[node] = true;

		Iterator<Entry<Integer, Integer>> i = adj[node].get(0).entrySet().iterator();

		while (i.hasNext()) {
			Entry<Integer, Integer> it = i.next();
			int n = it.getKey();
			if (!visited[n]) {
				tmp = prev + it.getValue();
				max = maximum(tmp, findLongest(n, adj, visited, max, tmp));
			}
			tmp = 0;
		}
		return max;
	}

	static int maximum(int a, int b) {
		return a > b ? a : b;
	}
}
