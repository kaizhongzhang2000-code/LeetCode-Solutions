class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int curr = 0;
        int max = Integer.MIN_VALUE;
        while(right < nums.length){
            if(curr <= 0){
                while(left < right){
                    curr = curr - nums[left];
                    left++;
                }                
            }
            curr = curr + nums[right];
            max = Math.max(max, curr);
            right++;
        }
        return max;
    }
}