class Solution {
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> bfs = new LinkedList<>();

        for(int r = 0; r < grid.length; r++)
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1)
                    fresh++;
                if(grid[r][c] == 2)
                    bfs.offer(new int[]{r, c});
        }
        
        int time = 0;

        while(fresh > 0 && !bfs.isEmpty()){
            int size = bfs.size();
            for(int i = 0; i < size; i++){
                int[] curr = bfs.poll();
                for(int[] dir : directions){
                    if(curr[0] + dir[0] >= 0 && curr[0] + dir[0] < grid.length
                    && curr[1] + dir[1] >= 0 && curr[1] + dir[1] < grid[0].length){
                        int R = curr[0];
                        int C = curr[1];
                        if(grid[R + dir[0]][C + dir[1]] == 1){
                            grid[R + dir[0]][C + dir[1]] = 2;
                            fresh--;
                            bfs.offer(new int[]{R + dir[0], C + dir[1]});
                        }
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}