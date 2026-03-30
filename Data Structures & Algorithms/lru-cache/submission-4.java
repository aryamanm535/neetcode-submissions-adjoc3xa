class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);  // updates and moves to most recent
            return;
        }

        if (cache.size() == capacity) {
            Iterator<Map.Entry<Integer, Integer>> it = cache.entrySet().iterator();
            it.next();
            it.remove();
        }

        cache.put(key, value);
    }
}