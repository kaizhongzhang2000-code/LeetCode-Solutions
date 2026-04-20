class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] info = new int[startTime.length][3];
        for(int i = 0; i < info.length; i++){
            info[i][0] = startTime[i];
            info[i][1] = endTime[i];
            info[i][2] = profit[i];
        }
        Arrays.sort(info, (a, b) -> {
            int compare = Integer.compare(a[0], b[0]);
            if(compare == 0){
                compare = Integer.compare(a[1], b[1]);
            }
            return compare;
        });

        int[] tracker = new int[info.length];
        Arrays.fill(tracker, -1);
        return dp(info, 0, tracker);
    }

    public int dp(int[][] info, int index, int[] tracker){
        if(index >= info.length){
            return 0;
        }
        if(tracker[index] >= 0){
           return tracker[index];
        }
        int skipProfit = dp(info, index + 1, tracker);
        int nextIndex = binarySearch(info, index);
        int adoptProfit = info[index][2] + dp(info, nextIndex, tracker);
        int maxProfit = Math.max(skipProfit, adoptProfit);
        tracker[index] = maxProfit;
        return maxProfit;
    }

    public int binarySearch(int[][] info, int index){
        int min = index + 1;
        int max = info.length - 1;
        int target = info[index][1];
        int result = info.length;
        while(max >= min){
            int curr = (max + min) / 2;
            if(info[curr][0] >= target){
                result = curr;
                max = curr - 1;
            } else {
                min = curr + 1;
            }
        }
        return result;
    }
}