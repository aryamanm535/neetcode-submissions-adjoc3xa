class Solution {
    final int INF = 2147483647;
    final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int R;
    private int C;

    public void islandsAndTreasure(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        for(int r = 0; r < R; r++)
            for(int c = 0; c < C; c++)
                if(grid[r][c] == 0)
                    dfs(grid, 0, r, c);
    }

    void dfs(int[][]grid, int curr, int r, int c){
        for(int[] dir : directions){
            int nr = dir[0];
            int nc = dir[1];
            if(r + nr >= 0 && c + nc >= 0 && r + nr < R && c + nc < C){
                if(grid[r + nr][c + nc] == -1)
                    continue;
                if(grid[r + nr][c + nc] != INF)
                    if(curr + 1 > grid[r + nr][c + nc])
                        continue;
     
                grid[r + nr][c + nc] = curr + 1;
                dfs(grid, curr + 1, r + nr, c + nc);
            }
        }
    }
}
