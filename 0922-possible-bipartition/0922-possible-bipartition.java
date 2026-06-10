class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] dislike : dislikes){
            List<Integer> list1 = adj.getOrDefault(dislike[0], new ArrayList<>());
            list1.add(dislike[1]);
            adj.put(dislike[0], list1);
            List<Integer> list2 = adj.getOrDefault(dislike[1], new ArrayList<>());
            list2.add(dislike[0]);
            adj.put(dislike[1], list2);
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 1; i <= n; i++){
            if(!set1.contains(i) && !set2.contains(i)){
                boolean fit = bfs(adj, i, set1, set2);
                if(!fit){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(Map<Integer, List<Integer>> adj, int i, Set<Integer> set1, Set<Integer> set2){
        boolean s1 = true;
        Queue<Integer> process = new LinkedList<>();
        process.offer(i);
        Set<Integer> candidates = new HashSet<>();
        while(process.size() > 0){
            int curr = process.poll();
            if(set1.contains(curr)){
                if(!s1){
                    return false;
                }
            } else if (set2.contains(curr)){
                if(s1){
                    return false;
                }
            } else {
                if (s1) {
                    set1.add(curr);
                } else {
                    set2.add(curr);
                }
                candidates.addAll(adj.getOrDefault(curr, new ArrayList<>()));
            }
            if(process.size() == 0){
                process.addAll(candidates);
                candidates.clear();
                s1 = !s1;
            }
        }
        return true;
    }
}