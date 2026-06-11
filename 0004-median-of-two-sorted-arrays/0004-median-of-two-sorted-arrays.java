class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = nums1.length - 1;
        while(true){
            int p1 = right >= left ? ((left + right) / 2) + 1 : 0;
            int p2 = ((nums1.length + nums2.length) / 2) - p1;
            int max1 = p1 -1 >= 0 ? nums1[p1 - 1] : Integer.MIN_VALUE;
            int min1 = p1 < nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            int max2 = p2 - 1 >= 0 ? nums2[p2 - 1] : Integer.MIN_VALUE;
            int min2 = p2 < nums2.length ? nums2[p2] : Integer.MAX_VALUE;
            if(max2 >= max1 && max2 <= min1){
                if((nums1.length + nums2.length) % 2 == 0){
                    return (double)(max2 + Math.min(min1, min2)) / 2;
                } else {
                    return Math.min(min1, min2);
                }
            } else if(max2 <= max1 && max1 <= min2){
                if((nums1.length + nums2.length) % 2 == 0){
                    return (double)(max1 + Math.min(min1, min2)) / 2;
                } else {
                    return Math.min(min1, min2);
                }
            } else if(max2 > min1){
                left = left == right ? p1 + 1 : p1;
            } else if(max1 > min2){
                right = left == right ? p1 - 2 : p1 - 1;
            }
        }
    }

}
//1 2 3 4 5 6 7 8
//1 2 3 4 5 6