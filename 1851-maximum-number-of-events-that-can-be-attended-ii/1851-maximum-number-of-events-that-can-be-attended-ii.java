class Solution {
    int max = 0;
    public int maxValue(int[][] events, int k) {
        int last = 0;
        for(int[] event : events){
            last = Math.max(last, event[1]);
        }
        Arrays.sort(events, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int[][] memo = new int[events.length + 1][k + 1];
        for(int[] line : memo){
            Arrays.fill(line, -1);
        }
        dp(0, 0, events, memo);
        return max;


    }
    public int dp(int attended, int processed, int[][] events, int[][] memo){
        if(attended >= memo[0].length - 1){
            return 0;
        }
        if(processed >= events.length){
            return 0;
        }
        if(memo[processed][attended] >= 0){
            return memo[processed][attended];
        }
        int start = binarySearch(events[processed][1] + 1, events);
        int skip = dp(attended, processed + 1, events, memo);
        int use = events[processed][2];
        if(start < events.length){
            use = use + dp(attended + 1, start, events, memo);
        }
        int val = Math.max(skip, use);
        max = Math.max(val, max);
        memo[processed][attended] = val;
        return val;
    }


    public int binarySearch(int time, int[][] events){
        int left = 0;
        int right = events.length - 1;
        while(left <= right){
            int pivot = (left + right) / 2;
            if(left == right){
                if(time <= events[left][0]){
                    return left;
                } else {
                    return left + 1;
                }
            }
            if(events[pivot][0] >= time){
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }
}