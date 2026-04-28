class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> curr, List<List<Integer>> result){
        if(index >= nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        int count = 1;
        while(index + 1 < nums.length && nums[index + 1] == nums[index]){
            count++;
            index++;
        }
        ArrayList<Integer> holder = new ArrayList<>(curr);
        for(int i = 0; i <= count; i++){
            dfs(nums, index + 1, curr, result);
            curr.add(nums[index]);         
        }
        for(int i = 0; i <= count; i++){
            curr.removeLast();
        }
    }
}