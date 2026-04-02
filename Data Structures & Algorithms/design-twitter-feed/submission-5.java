class Twitter {
    private Map<Integer, List<int[]>> data;
    private Map<Integer, Set<Integer>> following;
    private int time;

    public Twitter() {
        data = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        data.putIfAbsent(userId, new ArrayList<>());
        data.get(userId).add(new int[]{tweetId, time});  
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        if (data.containsKey(userId)) {
            for (int[] tweet : data.get(userId)) {
                pq.offer(tweet);
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
        }
        if(following.containsKey(userId)){
                for(int followee : following.get(userId)){
                    if (!data.containsKey(followee)) 
                        continue;
                    for(int[] tweet : data.get(followee)){
                        pq.offer(tweet);
                        if(pq.size() > 10)
                            pq.poll();
                    }
                }
        }

        while(!pq.isEmpty())
            res.add(0, pq.poll()[0]);

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) 
            return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            return;
        }
        following.get(followerId).remove(followeeId);
    }
}
