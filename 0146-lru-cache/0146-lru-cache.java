class LRUCache {
    Set<Integer> recentSequence = new LinkedHashSet<>();
    Map<Integer, Integer> timeMap = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(this.recentSequence.contains(key)){
            this.recentSequence.remove(key);
            this.recentSequence.add(key);
        }
        int value = this.timeMap.getOrDefault(key, -1);
        return value;
    }
    
    public void put(int key, int value) {
        if(this.recentSequence.contains(key)){
            this.recentSequence.remove(key);
            this.recentSequence.add(key);
            this.timeMap.put(key, value);
        } else {
            if(this.recentSequence.size() >= this.capacity){
                int toRemove = this.recentSequence.iterator().next();
                this.recentSequence.remove(toRemove);
                this.timeMap.remove(toRemove);
            }
            this.recentSequence.add(key);
            this.timeMap.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */