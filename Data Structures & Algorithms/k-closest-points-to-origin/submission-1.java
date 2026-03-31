class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> distSq(b) - distSq(a));
        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) heap.poll();
        }
        return heap.toArray(new int[k][]);
    }

    private int distSq(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}