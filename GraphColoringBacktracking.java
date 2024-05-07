import java.util.*;

public class GraphColoringBacktracking {

    static boolean isSafe(int[][] graph, int[] colors, int v, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && c == colors[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean graphColoringUtil(int[][] graph, int m, int[] colors, int v) {
        if (v == graph.length)
            return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(graph, colors, v, c)) {
                colors[v] = c;
                if (graphColoringUtil(graph, m, colors, v + 1))
                    return true;
                colors[v] = 0; // Backtrack
            }
        }

        return false;
    }

    static void graphColoring(int[][] graph, int m) {
        int V = graph.length;
        int[] colors = new int[V];
        Arrays.fill(colors, 0);

        if (!graphColoringUtil(graph, m, colors, 0)) {
            System.out.println("Solution does not exist");
            return;
        }

        System.out.println("Solution exists with following color assignments:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " --> Color " + colors[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0}
        };
        int m = 3; // Number of colors

        graphColoring(graph, m);
    }
}