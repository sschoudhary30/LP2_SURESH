import java.util.*;

public class DijkstraMST {

    static final int INF = Integer.MAX_VALUE;

    static void dijkstraMST(int graph[][], int V) {
        // Array to store the parent of each vertex in MST
        int parent[] = new int[V];
        // Array to store the weight of the edge connecting each vertex to the MST
        int key[] = new int[V];
        // Array to track if a vertex is included in the MST
        boolean mstSet[] = new boolean[V];

        // Initialize all keys as INFINITE and all vertices as not part of MST
        Arrays.fill(key, INF);
        Arrays.fill(mstSet, false);

        // Start with the first vertex as the root of the MST
        key[0] = 0;
        parent[0] = -1; // No parent for the root

        // Construct the MST
        for (int count = 0; count < V - 1; count++) {
            // Find the vertex with the minimum key value that is not yet included in MST
            int u = minKey(key, mstSet, V);
            // Mark the selected vertex as part of MST
            mstSet[u] = true;
            // Update the key value and parent index of adjacent vertices of the selected vertex
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the edges of MST
        printMST(parent, graph, V);
    }

    static int minKey(int key[], boolean mstSet[], int V) {
        int min = INF, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    static void printMST(int parent[], int graph[][], int V) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        dijkstraMST(graph, 5);
    }
}