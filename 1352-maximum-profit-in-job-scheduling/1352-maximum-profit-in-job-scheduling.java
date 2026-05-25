class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] allInfo = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++){
            allInfo[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(allInfo, (a, b) -> {
            int compare = Integer.compare(a[1], b[1]);
            if(compare == 0){
                compare = Integer.compare(b[0], a[0]);
            }
            if(compare == 0){
                compare = Integer.compare(a[2], b[2]);
            }
            return compare;
        });

        int[] dp = new int[allInfo.length];
        int max = 0;
        for(int i = 0; i < allInfo.length; i++){
            int lastIndex = i - 1;
            while(lastIndex >= 0){
                if(allInfo[lastIndex][1] <= allInfo[i][0]){
                    break;
                }
                lastIndex--;
            }
            int prevMax = 0;
            if(lastIndex >= 0){
                prevMax = dp[lastIndex];
            }
            int prev = 0;
            if(i - 1 >= 0){
                prev = dp[i - 1];
            }
            dp[i] = Math.max(prev, prevMax + allInfo[i][2]);
            max = Math.max(max, dp[i]);
        }
        return max;
        
    }
}