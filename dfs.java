import java.util.*;

public class dfs {
    private int V; // Number of vertices
    private int[][] adj; // Adjacency list representation

    // Constructor
    public dfs(int v) {
        V = v;
        adj = new int[v][v];
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj[v][w] = 1; // Add w to v's list.
        adj[w][v] = 1; // For undirected graph
    }

    // Depth First Search (DFS)
    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1 && !visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    // DFS traversal of the vertices reachable from v.
    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        dfs g = new dfs(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Depth First Traversal starting from vertex 2:");
        g.DFS(2);
    }
}
