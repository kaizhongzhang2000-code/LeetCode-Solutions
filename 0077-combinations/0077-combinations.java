class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(queue, result, new ArrayList<>(), k);
        return result;
    }

    public void dfs(Queue<Integer> queue, List<List<Integer>> result, List<Integer> curr, int k){
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size() + queue.size() < k){
            return;
        }
        int now = queue.poll();
        dfs(queue, result, curr, k);
        curr.add(now);
        dfs(queue, result, curr, k);
        curr.removeLast();
        queue.offer(now);
    }
}