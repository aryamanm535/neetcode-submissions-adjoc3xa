class Solution {
    private final int[][]directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int R;
    private int C;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        R = heights.length;
        C = heights[0].length;
        boolean[][] atl = new boolean[R][C];
        boolean[][] pac = new boolean[R][C];

        for(int r = 0; r < R; r++){
            dfs(heights, r, C-1, atl);
            dfs(heights, r, 0, pac);
        }

        for(int c = 0; c < C; c++){
            dfs(heights, R-1, c, atl);
            dfs(heights, 0, c, pac);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < R; r++)
            for(int c = 0; c < C; c++)
                if(pac[r][c] && atl[r][c])
                    res.add(Arrays.asList(r, c));
        
        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][]ocean){
        ocean[r][c] = true;
        for(int[] dir : directions){
            int nr = dir[0];
            int nc = dir[1];
            if(!(r + nr < 0 || c + nc < 0 || r + nr >= R || c + nc >= C)){
                if(ocean[r+nr][c+nc] == true)
                    continue;
                if(heights[r][c] <= heights[r+nr][c+nc]){
                    dfs(heights, r + nr, c + nc, ocean);
                }
            }
        }
    }
}
