class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> curr, List<List<Integer>> result){
        if(index >= nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        dfs(nums, index + 1, curr, result);
        curr.add(nums[index]);
        dfs(nums, index + 1, curr, result);
        curr.removeLast();
    }
}