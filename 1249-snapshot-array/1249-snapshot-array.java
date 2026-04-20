class SnapshotArray {
    int snapCount = 0;
    Map<Integer, List<Integer>> snapShotIndex = new HashMap<>();
    List<Map<Integer, Integer>> indexToValue = new ArrayList<>();
    Map<Integer, Integer> changes = new HashMap<>();
    public SnapshotArray(int length) {
        for(int i = 0; i < length; i++){
            List<Integer> newList = new ArrayList<>();
            newList.add(-1);
            Map<Integer, Integer> newMap = new HashMap<>();
            newMap.put(-1, 0);
            this.snapShotIndex.put(i, newList);
            this.indexToValue.add(newMap);
        }
    }
    
    public void set(int index, int val) {
        this.changes.put(index, val);
    }
    
    public int snap() {
        for(int key : this.changes.keySet()){
            List<Integer> indexes = this.snapShotIndex.get(key);
            indexes.add(snapCount);
            this.snapShotIndex.put(key, indexes);
            Map<Integer, Integer> indexValue = indexToValue.get(key);
            indexValue.put(snapCount, this.changes.get(key));
            this.indexToValue.set(key, indexValue);
        }
        this.changes.clear();
        snapCount++;
        return snapCount - 1;
    }
    
    public int get(int index, int snap_id) {
        List<Integer> indexList = this.snapShotIndex.get(index);
        int targetIndex = Collections.binarySearch(indexList, snap_id);
        if(targetIndex < 0){
            targetIndex = -targetIndex - 2;
        }
        return this.indexToValue.get(index).get(indexList.get(targetIndex));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */