import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS {
	// prints BFS traversal from a given source s
	private static void DFS(int s, LinkedList<Integer>[] adj, boolean[] visited) {
		// Create a queue for DFS

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		System.out.print(s + " ");
		
		if(adj.length > s){
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()){
	            int n = i.next();
	            if (!visited[n])
	            	DFS(n, adj, visited);
	        }
		}
	}

	public static void main(String args[]) {
		LinkedList<Integer> adj[]; // Adjacency Lists
		boolean[] visited = new boolean[100];

		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);

		// Start node
		int node = sc.nextInt();

		// No. of edges
		int V = sc.nextInt();
		adj = new LinkedList[V];

		for (int i = 0; i < V; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < V; i++) {
			int v = sc.nextInt();
			int w = sc.nextInt();
			adj[v].add(w);
		}
		sc.close();

		System.out.println("Following is Depth First Traversal " + "(starting from vertex " + node + ")");

		DFS(node, adj, visited);
	}
}
