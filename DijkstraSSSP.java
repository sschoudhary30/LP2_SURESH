import java.util.*;

public class DijkstraSSSP {

    static final int INF = Integer.MAX_VALUE;

    // Dijkstra's algorithm implementation
    static void dijkstra(int graph[][], int src, int V) {
        int dist[] = new int[V]; // Array to store shortest distances from source
        Arrays.fill(dist, INF); // Initialize distances with INFINITE
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v])); // Priority queue for vertices
        dist[src] = 0; // Distance from source to source is 0
        pq.add(src); // Add source vertex to priority queue

        // Main loop
        while (!pq.isEmpty()) {
            int u = pq.poll(); // Extract the vertex with minimum distance from priority queue
            // Traverse adjacent vertices of u
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0) { // If there is an edge from u to v
                    if (dist[v] > dist[u] + graph[u][v]) { // If a shorter path is found
                        dist[v] = dist[u] + graph[u][v]; // Update distance to v
                        pq.add(v); // Add v to priority queue for further exploration
                    }
                }
            }
        }

        // Print the distances from source to all vertices
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int graph[][] = new int[][]{
                {0, 10, 0, 3},   // Edges from vertex 0
                {4, 0, 8, 0},   // Edges from vertex 1
                {0, 2, 4, 9},   // Edges from vertex 2
                {6, 0, 7, 0}    // Edges from vertex 3
        };

        // Call Dijkstra's algorithm with the graph, source vertex, and number of vertices
        dijkstra(graph, 0, 4);
    }
}
