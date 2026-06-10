class Solution {
    long count = 0;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int[] nums = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            nums[i] = nums1[i] - nums2[i];
        }
        mergeSort(nums, 0, nums.length - 1, new int[nums1.length], diff);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right, int[] memo, int diff){
        if(right <= left){
            return;  
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, memo, diff);
        mergeSort(nums, mid + 1, right, memo, diff);
        int index1 = left;
        int index2 = mid + 1;
        int i = left;
        int countedIndex = left;
        int index3 = mid + 1;
        while(i <= right){
            int n1 = index1 > mid ? Integer.MAX_VALUE : nums[index1];
            int n2 = index2 > right ? Integer.MAX_VALUE : nums[index2];
            memo[i] = Math.min(n1, n2);
            if(index1 >= countedIndex && n1 <= nums[right] + diff){
                while(index3 <= right){
                    if(nums[index3] + diff < n1){
                        index3++;
                    } else {
                        break;
                    }
                }
                countedIndex++;
                count = count + right - index3 + 1;
            }
            if(n1 < n2){
                index1++;
            } else {
                index2++;
            }
            i++;
        }
        for(int j = left; j <= right; j++){
            nums[j] = memo[j];
        }

    }
}