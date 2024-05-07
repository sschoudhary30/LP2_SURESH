import java.util.*;

class AStar {
    // Define a Node class to represent each position in the grid
    static class Node {
        int x, y; // Coordinates of the node
        int f; // Total cost of the node
        Node parent; // Parent node

        // Constructor to initialize a node
        Node(int x, int y, int f, Node parent) {
            this.x = x;
            this.y = y;
            this.f = f;
            this.parent = parent;
        }
    }

    // A* algorithm implementation
    static List<int[]> findPath(int[][] grid, int[] start, int[] end) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        // Possible movement directions (up, down, left, right)
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // Priority queue for the open set, ordering nodes by their f value
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));

        // Create a start node with initial f value based on heuristic
        Node startNode = new Node(start[0], start[1], calculateHeuristic(start[0], start[1], end[0], end[1]), null);
        openSet.add(startNode);

        // Matrix to track visited nodes
        boolean[][] visited = new boolean[numRows][numCols];

        // Iterate until openSet is empty (no path found) or goal reached
        while (!openSet.isEmpty()) {
            Node current = openSet.poll(); // Get the node with the lowest f value

            // Check if the current node is the goal
            if (current.x == end[0] && current.y == end[1]) {
                // Reconstruct the path from the goal node to the start node
                List<int[]> path = new ArrayList<>();
                while (current != null) {
                    path.add(new int[]{current.x, current.y});
                    current = current.parent;
                }
                Collections.reverse(path);
                return path;
            }

            visited[current.x][current.y] = true; // Mark the current node as visited

            // Explore neighbors
            for (int i = 0; i < 4; ++i) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                // Check if the new position is within bounds and not an obstacle
                if (newX >= 0 && newX < numRows && newY >= 0 && newY < numCols && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    int newF = current.f + 1 + calculateHeuristic(newX, newY, end[0], end[1]); // Calculate new f value for the neighbor
                    Node neighbor = new Node(newX, newY, newF, current);

                    openSet.add(neighbor); // Add the neighbor to the open set
                }
            }
        }

        return Collections.emptyList(); // If no path found
    }

    // Helper function to calculate the heuristic (Manhattan distance)
    static int calculateHeuristic(int x, int y, int targetX, int targetY) {
        return Math.abs(targetX - x) + Math.abs(targetY - y);
    }

    public static void main(String[] args) {
        // Define the grid with obstacles (1s) and free spaces (0s)
        int[][] grid = {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };

        // Define start and end coordinates
        int[] start = {0, 0};
        int[] end = {4, 4};

        // Find the path using A* algorithm
        List<int[]> path = findPath(grid, start, end);

        // Print the result
        if (path.isEmpty())
            System.out.println("No path found.");
        else {
            System.out.println("Path found:");
            for (int[] point : path)
                System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }
}
