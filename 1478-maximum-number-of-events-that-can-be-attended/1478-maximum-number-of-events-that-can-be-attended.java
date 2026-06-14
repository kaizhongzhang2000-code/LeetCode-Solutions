class Solution {
    public int maxEvents(int[][] events) {
        int timeLimit = 0;
        for(int[] event : events){
            timeLimit = Math.max(timeLimit, event[1]);
        }
        Arrays.sort(events, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        PriorityQueue<int[]> earliest = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int i = 0;
        int time = 0;
        int count = 0;
        while(time <= timeLimit){
            while(i < events.length && events[i][0] <= time){
                earliest.offer(events[i]);
                i++;
            }
            while(earliest.size() > 0 && earliest.peek()[1] < time){
                earliest.poll();
            }
            if(!earliest.isEmpty()){
                System.out.println(Arrays.toString(earliest.poll()));
                count++;
            }
            time++;
        }

        return count;
    }
}

