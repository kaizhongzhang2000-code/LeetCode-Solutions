class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int compare = Integer.compare(a[1], b[1]);
            if(compare == 0){
                compare = Integer.compare(b[0], a[0]);
            }
            return compare;
        });
        int start = Integer.MIN_VALUE;
        int total = intervals.length;
        for(int[] interval : intervals){
            if(interval[0] >= start){
                total--;
                start = interval[1];
            } else {
                continue;
            }
        }
        return total;
    }
}