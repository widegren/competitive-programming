import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class BFS {

	// prints BFS traversal from a given source s
	private static void BFT(int s, LinkedList<Integer>[] adj, boolean[] visited) {
		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");
			
			for(LinkedList<Integer> i : adj){
				if(i.size() != 0){
					for( int c : i){
						if (!visited[c]) {
							visited[c] = true;
							queue.add(c);
						}
					}
				}
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
		
		for(int i=0;i<V;++i){
			adj[i] = new LinkedList<Integer>();
		}
		for(int i = 0; i < V;i++){
			int v = sc.nextInt();
			int w = sc.nextInt();
			adj[v].add(w);
		}
		sc.close();

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex "+node+")");

		BFT(node, adj, visited);
	}
}