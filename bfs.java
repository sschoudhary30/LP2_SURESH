import java.util.*;

public class bfs {
    private int V; // Number of vertices
    private int[][] adj; // Adjacency list representation

    // Constructor
    public bfs(int v) {
        V = v;
        adj = new int[v][v];
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v][w] = 1; // Add w to v's list.
        adj[w][v] = 1; // For undirected graph
    }

    // Breadth First Search (BFS)
    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            for (int i = 0; i < V; i++) {
                if (adj[s][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        bfs g = new bfs(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Breadth First Traversal starting from vertex 2:");
        g.BFS(2);
    }
}



//import java.util.*;

/*public class BFS {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list representation

    // Constructor
    public BFS(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w); // Add w to v's list.
        adj.get(w).add(v); // For undirected graph
    }

    // Breadth First Search (BFS)
    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            for (int n : adj.get(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Breadth First Traversal starting from vertex 2:");
        g.BFS(2);
    }
}
*/