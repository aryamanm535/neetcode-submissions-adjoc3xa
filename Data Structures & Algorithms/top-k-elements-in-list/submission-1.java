class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(count.containsKey(nums[i])){
                int c = count.get(nums[i]);
                count.put(nums[i], c+1);
            }
            else
                count.put(nums[i], 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Iterator<Integer> it = count.keySet().iterator();

        while(it.hasNext()){
            int key = it.next();
            int val = count.get(key);
            pq.offer(new int[]{key, val});
            if(pq.size() > k)
                pq.poll();
        }

        int[] res = new int[pq.size()];
        int i = 0;
        for (int[] num : pq) {
            res[i++] = num[0];
        }

        return res;
    }
}
