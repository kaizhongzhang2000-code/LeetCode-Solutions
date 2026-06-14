class SnapshotArray {
    private final int size;
    private int version = 0;
    private Map<Integer, Integer> currChange = new HashMap<>();
    private Map<Integer, List<int[]>> history = new HashMap<>();
    public SnapshotArray(int length) {
        this.size = length;
    }
    
    public void set(int index, int val) {
        this.currChange.put(index, val);
    }
    
    public int snap() {
        for(int i : this.currChange.keySet()){
            List<int[]> histList = this.history.getOrDefault(i, new ArrayList<>());
            histList.add(new int[]{this.version, currChange.get(i)});
            this.history.put(i, histList);
        }
        this.version++;
        this.currChange.clear();
        return this.version - 1;
        
    }
    
    public int get(int index, int snap_id) {
        List<int[]> histList = this.history.getOrDefault(index, new ArrayList<>());
        int pos = binarySearch(histList, new int[]{snap_id, 0});
        if(pos < 0){
            pos = - pos - 2;
        }
        int[] result = pos >= 0 && histList.size() > 0 ? histList.get(pos) : new int[]{0, 0};
        return result[1];
    }

    public int binarySearch(List<int[]> histList, int[] target){
        int left = 0;
        int right = histList.size() - 1;
        while(left <= right){
            int pivot = (left + right) / 2;
            int id = histList.get(pivot)[0];
            if(left == right){
                if(id <= target[0]){
                    return left;
                } else {
                    return left - 1;
                }
            }
            if(id >= target[0]){
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */