class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        Queue<Integer> targets = new LinkedList<>();
        List<Integer> candidates = new ArrayList<>();
        Set<Integer> processed = new HashSet<>();
        targets.offer(arr.length - 1);
        processed.add(arr.length - 1);
        for(int i = 0; i < arr.length; i++){
            List<Integer> indexes = indexMap.getOrDefault(arr[i], new ArrayList<>());
            indexes.add(i);
            indexMap.put(arr[i], indexes);
        }

        int count = 0;
        while(targets.size() > 0){
            int curr = targets.poll();
            if(curr == 0){
                break;
            }

            List<Integer> equals = indexMap.getOrDefault(arr[curr], new ArrayList<>());
            for(int equal : equals){
                if(processed.contains(equal)){
                    continue;
                }
                candidates.add(equal);
                processed.add(equal);
            }
            indexMap.remove(arr[curr]);
            if(curr - 1 >= 0 && !processed.contains(curr - 1)){
                candidates.add(curr - 1);
                processed.add(curr - 1);
            }
            if(curr + 1 < arr.length && !processed.contains(curr + 1)){
                candidates.add(curr + 1);
                processed.add(curr + 1);
            }
            if(targets.size() == 0){
                targets.addAll(candidates);
                candidates.clear();
                count++;
            }
        }
        return count;
    }
}