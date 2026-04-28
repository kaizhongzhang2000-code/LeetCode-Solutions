class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] candidates, int target, int curr, int index, List<Integer> currList, List<List<Integer>> result){
        if(curr == target){
            result.add(new ArrayList<>(currList));
        }
        for(int i = index; i < candidates.length; i++){
            if(curr + candidates[i] <= target){
                currList.add(candidates[i]);
                dfs(candidates, target, curr + candidates[i], i, currList, result);
                currList.removeLast();
            }
        }
    }

}