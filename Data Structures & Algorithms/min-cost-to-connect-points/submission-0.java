class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // {pointIndex, costToAdd}
        pq.offer(new int[]{0, 0});
        
        int result = 0;
        int edgesUsed = 0;

        while (edgesUsed < n) {
            int[] curr = pq.poll();
            int u = curr[0];
            int cost = curr[1];

            if (visited[u]) continue;

            visited[u] = true;
            result += cost;
            edgesUsed++;

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) 
                             + Math.abs(points[u][1] - points[v][1]);
                    pq.offer(new int[]{v, dist});
                }
            }
        }

        return result;
    }
}