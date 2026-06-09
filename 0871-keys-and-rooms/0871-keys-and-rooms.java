class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> keys = new LinkedList<>();
        keys.offer(0);
        Set<Integer> visited = new HashSet<>();
        while(keys.size() > 0){
            int key = keys.poll();
            visited.add(key);
            for(int room : rooms.get(key)){
                if(!visited.contains(room)){
                    keys.offer(room);
                }
            }
        }
        if(visited.size() < rooms.size()){
            return false;
        }
        return true;
    }
}