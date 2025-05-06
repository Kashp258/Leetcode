

class Solution {
    public Boolean isSafe(int row, int col, char[][] board) {
        // horizontal row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') return false;
        }

        // vertical row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Upper left 
        int r = row, c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r--; c--;
        }

        // Upper right
        r = row; c = col;
        while (r >= 0 && c < board.length) {
            if (board[r][c] == 'Q') return false;
            r--; c++;
        }

        // Lower left 
        r = row; c = col;
        while (r < board.length && c >= 0) {
            if (board[r][c] == 'Q') return false;
            r++; c--;
        }

        // Lower right
        r = row; c = col;
        while (r < board.length && c < board.length) {
            if (board[r][c] == 'Q') return false;
            r++; c++;
        }

        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoard) {
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                row.append(board[i][j]);
            }
            newBoard.add(row.toString());
        }

        allBoard.add(newBoard);
    }

    public void helper(char[][] board, List<List<String>> allBoard, int col) {
        if (col == board.length) {
            saveBoard(board, allBoard);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoard, col + 1);
                board[row][col] = '.'; 
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(board, allBoard, 0);
        return allBoard;
    }
}