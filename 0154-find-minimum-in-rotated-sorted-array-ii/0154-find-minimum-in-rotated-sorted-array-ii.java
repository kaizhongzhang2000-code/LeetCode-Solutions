class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(right - left == 1){
                return Math.min(nums[left], nums[right]);
            }
            int mid = (left + right) / 2;
            if(nums[left] <= nums[mid] && nums[mid] <= nums[right]){
                right -= 1;
            } else if(nums[right] < nums[mid]){
                left = mid;
            } else if(nums[left] > nums[mid]){
                right = mid;
            }
        }
        return nums[left];
    }
}