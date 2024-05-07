import java.util.*;

public class KruskalMST {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        parent[x] = y;
    }

    static void kruskalMST(Edge[] edges, int V) {
        Edge[] result = new Edge[V];
        int e = 0;

        Arrays.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        int i = 0;

        while (e < V - 1 && i < edges.length) {
            Edge nextEdge = edges[i++];

            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }

        System.out.println("Edges of Minimum Spanning Tree:");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        Edge[] edges = new Edge[E];
        edges[0] = new Edge(0, 1, 10);
        edges[1] = new Edge(0, 2, 6);
        edges[2] = new Edge(0, 3, 5);
        edges[3] = new Edge(1, 3, 15);
        edges[4] = new Edge(2, 3, 4);

        kruskalMST(edges, V);
    }
}
