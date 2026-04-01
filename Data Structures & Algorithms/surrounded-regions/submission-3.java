class Solution {
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int R;
    private int C;

    public void solve(char[][] board) {
        R = board.length;
        C = board[0].length;
        for(int r = 0; r < R; r++){
            if(board[r][0] == 'O')
                dfs(board, r, 0);
            if(board[r][C-1] == 'O')
                dfs(board, r, C-1);
        }

        for(int c = 0; c < C; c++){
            if(board[0][c] == 'O')
                dfs(board, 0, c);
            if(board[R-1][c] == 'O')
                dfs(board, R-1, c);
        }

        for(int r = 0; r < R; r++)
            for(int c = 0; c < C; c++){
                if(board[r][c] == 'O')
                    board[r][c] = 'X';    
                else if(board[r][c] == 'T')
                    board[r][c] = 'O';     
            }
    }

    private void dfs(char[][] board, int r, int c){
        board[r][c] = 'T';
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (!(nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] != 'O')){
                dfs(board, nr, nc);
            }
        }
    }
}
