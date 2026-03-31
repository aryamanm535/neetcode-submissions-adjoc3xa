class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->Double.compare(dist(a), dist(b)));
        for(int i = 0; i < points.length; i++)
            heap.offer(points[i]);
        
        int result[][] = new int[k][2];
        int i = 0;
        while(i != k){
            result[i] = heap.remove();
            i++;
        }

        return result;
    }

    private double dist(int[] point){
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
