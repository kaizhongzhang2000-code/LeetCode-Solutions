class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] allInfo = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++){
            allInfo[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(allInfo, (a, b) -> {
            int compare = Integer.compare(a[1], b[1]);
            return compare;
        });

        int[] dp = new int[allInfo.length];
        int max = 0;
        for(int i = 0; i < allInfo.length; i++){
            int lastIndex = binarySearch(allInfo, allInfo[i][0]);
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

    public int binarySearch(int[][] allInfo, int target){
        int left = 0;
        int right = allInfo.length - 1;
        while(left < right){
            int pivot = (left + right) / 2;

        if(allInfo[pivot][1] > target){
            right = pivot - 1;
        } else {
            left = pivot + 1;
        }
        }
        if(allInfo[left][1] > target){
            return left - 1;
        }
        return left;
    }
}