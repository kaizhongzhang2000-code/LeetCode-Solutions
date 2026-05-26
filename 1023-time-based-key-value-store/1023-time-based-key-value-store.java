class TimeMap {
    Map<String, List<String>> valueMap = new HashMap<>();
    Map<String, List<Integer>> timestampMap = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<String> valueList = this.valueMap.getOrDefault(key, new ArrayList<>());
        List<Integer> timestampList = this.timestampMap.getOrDefault(key, new ArrayList<>());
        valueList.add(value);
        timestampList.add(timestamp);
        valueMap.put(key, valueList);
        timestampMap.put(key, timestampList);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> timestampList = this.timestampMap.getOrDefault(key, new ArrayList<>());
        int index = Collections.binarySearch(timestampList, timestamp);
        if(index < 0){
            index = - index - 2;
        }
        return index < 0 ? "" : this.valueMap.get(key).get(index); 
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */