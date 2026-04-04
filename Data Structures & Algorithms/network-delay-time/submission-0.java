class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        // dist[i] = shortest time from k to i
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // min-heap: {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[1];
            int t = curr[0];
            if(visited[node])
                continue;
            visited[node] = true;
            
            for(int[] next : adj.get(node)){
                int v = next[0];
                int w = next[1];
                if(dist[v] > t + w){
                    dist[v] = t + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
