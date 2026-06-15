class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseBlocker = new HashMap<>();
        int[] blockingTracker = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < prerequisites.length; i++){
            int[] prereq = prerequisites[i];
            blockingTracker[prereq[1]]++;
            courseBlocker.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
        }
        Queue<Integer> notBlocking = new LinkedList<>();
        for(int i = 0; i < blockingTracker.length; i++){
            if(blockingTracker[i] == 0){
                notBlocking.offer(i);
            }
        }
        while(notBlocking.size() > 0){
            int curr = notBlocking.poll();
            result.add(curr);
            List<Integer> blockers = courseBlocker.getOrDefault(curr, new ArrayList<>());
            for(int blocker : blockers){
                blockingTracker[blocker]--;
                if(blockingTracker[blocker] == 0){
                    notBlocking.offer(blocker);
                }
            }
        }
        if(result.size() < numCourses){
            return new int[0];
        }
        Collections.reverse(result);
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }


    
}
