class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int R;
    private int C;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        R = heights.length;
        C = heights[0].length;
        boolean[][] pac = new boolean[R][C];
        boolean[][] atl = new boolean[R][C];

        for(int r = 0; r < R; r++){
            dfs(heights, r, 0, pac);
            dfs(heights, r, C-1, atl);
        }

        for(int c = 0; c < C; c++){
            dfs(heights, 0, c, pac);
            dfs(heights, R-1, c, atl);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < R; r++)
            for(int c = 0; c < C; c++)
                if(pac[r][c] && atl[r][c])
                    res.add(Arrays.asList(r, c));
        
        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean){
        ocean[r][c] = true;
        for(int[] dir : directions){
            int dr = dir[0];
            int dc = dir[1];
            if(r + dr < R && c + dc < C && r + dr >= 0 && c + dc >= 0){
                if(ocean[r+dr][c+dc] == true)
                    continue;
                if(heights[r+dr][c+dc] >= heights[r][c])
                    dfs(heights, r+dr, c+dc, ocean);
            }
        }
        return;
    }
}
