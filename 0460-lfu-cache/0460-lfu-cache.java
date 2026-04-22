class LFUCache {
    Map<Integer, int[]> cacheMap = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> frequencyMap = new HashMap<>();
    int minf = 0;
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        int[] freqValue = cacheMap.get(key);
        int freq = freqValue[0];
        int value = freqValue[1];
        LinkedHashSet<Integer> freqSet = frequencyMap.get(freq);
        freqSet.remove(key);
        LinkedHashSet<Integer> newFreqSet = frequencyMap.getOrDefault(freq + 1, new LinkedHashSet<>());
        newFreqSet.add(key);
        if(freqSet.size() == 0 && minf == freq){
            minf++;
        }
        frequencyMap.put(freq, freqSet);
        frequencyMap.put(freq + 1, newFreqSet);

        freqValue[0] = freqValue[0] + 1;
        cacheMap.put(key, freqValue);
        return value;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            int[] freqValue = cacheMap.get(key);
            freqValue[1] = value;
            cacheMap.put(key, freqValue);
            get(key);
        } else {
            if(cacheMap.size() >= capacity){
                LinkedHashSet<Integer> lowFreq = frequencyMap.get(minf);
                int keyToRemove = lowFreq.iterator().next();
                lowFreq.remove(keyToRemove);
                frequencyMap.put(minf, lowFreq);
                cacheMap.remove(keyToRemove);
            }
            cacheMap.put(key, new int[]{1, value});
            LinkedHashSet<Integer> oneFreq = frequencyMap.getOrDefault(1, new LinkedHashSet<>());
            oneFreq.add(key);
            frequencyMap.put(1, oneFreq);
            minf = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */