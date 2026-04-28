class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Queue<Integer> numQueue = new LinkedList<>();
        for(int num : nums){
            numQueue.offer(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(numQueue, new ArrayList<>(), result);
        return result;
    }

    public void dfs(Queue<Integer> numQueue, List<Integer> curr, List<List<Integer>> result){
        if(numQueue.size() == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < numQueue.size(); i++){
            int process = numQueue.poll();
            curr.add(process);
            dfs(numQueue, curr, result);
            curr.removeLast();
            numQueue.offer(process);
        }
    }

}