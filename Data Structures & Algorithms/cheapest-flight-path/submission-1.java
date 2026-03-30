class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.get(from).add(new int[]{to, price});
        }

        // {totalCost, node, stopsUsed}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});

        int[] bestStops = new int[n];
        Arrays.fill(bestStops, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            int stops = curr[2];

            if (node == dst) return cost;

            if (stops > k || stops > bestStops[node]) continue;
            bestStops[node] = stops;

            for (int[] nei : adj.get(node)) {
                int nextNode = nei[0];
                int price = nei[1];
                pq.offer(new int[]{cost + price, nextNode, stops + 1});
            }
        }

        return -1;
    }
}