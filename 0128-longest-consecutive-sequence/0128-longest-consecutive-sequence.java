class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        int longest = 0;
        Set<Integer> processed = new HashSet<>();
        for(int num : numSet){
            if(!processed.contains(num)){
                longest = Math.max(longest, dfs(numSet, processed, num));
            }
        }
        return longest;
        
    }

    public int dfs(Set<Integer> numSet, Set<Integer> processed, int num){
        if(!numSet.contains(num) || processed.contains(num)){
            return 0;
        }
        processed.add(num);
        return 1 + dfs(numSet, processed, num - 1) + dfs(numSet, processed, num + 1);
    }
}