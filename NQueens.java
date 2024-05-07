public class NQueens {
    static int N = 4; // Number of queens

    // Function to check if a queen can be placed at (row, col)
    static boolean isSafe(int[][] board, int row, int col) {
        // Check for queens in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check for queens in the upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check for queens in the upper right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Function to solve the n-queens problem using backtracking
    static boolean solveNQueens(int[][] board, int row) {
        if (row == N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 1;

                if (solveNQueens(board, row + 1))
                    return true;

                board[row][i] = 0; // Backtrack
            }
        }
        return false;
    }

    // Function to print the board
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[N][N];

        if (solveNQueens(board, 0))
            printBoard(board);
        else
            System.out.println("Solution does not exist.");
    }
}