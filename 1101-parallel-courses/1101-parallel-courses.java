class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> noChild = new HashSet<>();
        for(int i = 1; i <= n; i++){
            noChild.add(i);
        }
        for(int[] relation : relations) {
            List<Integer> prereq = map.getOrDefault(relation[1], new ArrayList<>());
            prereq.add(relation[0]);
            map.put(relation[1], prereq);
            noChild.remove(relation[0]);
        }
        if(noChild.size() == 0){
            return -1;
        }
        int count = 0;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        for(int i : noChild){
            int result = dfs(map, i, memo, new HashSet<>());
            if(result < 0){
                return -1;
            }

            count = Math.max(count, result);
        }
        for(int i : memo){
            if(i < 0){
                return -1;
            }
        }
        return count;
    }

    public int dfs(Map<Integer, List<Integer>> map, int i, int[] memo, Set<Integer> visited){
        if(memo[i -1] >= 0){
            return memo[i - 1];
        }
        if(visited.contains(i)){
            return -1;
        }
        int count = 0;
        visited.add(i);
        for(int parent : map.getOrDefault(i, new ArrayList<>())) {
            int val = dfs(map, parent, memo, visited);
            if(val < 0){
                return -1;
            }
            count = Math.max(count, val);
        }
        visited.remove(i);
        memo[i - 1] = count + 1;
        return count + 1;
    }
}