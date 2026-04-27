class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int total = nums[0];
        while(left <= right){
            if(total >= target){
                length = Math.min(length, right - left + 1);
            }
            if(right + 1 == nums.length){
                if(total < target){
                    break;
                }
                total -= nums[left];
                left++;
                continue;
            }
            
            right++;
            total += nums[right];
            while(total - nums[left] >= target){
                total -= nums[left];
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}