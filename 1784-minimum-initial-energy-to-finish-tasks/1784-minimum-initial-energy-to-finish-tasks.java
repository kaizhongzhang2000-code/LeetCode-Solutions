class Solution {
    public int minimumEffort(int[][] tasks) {
        int total = 0;
        int cost = 0;
        Arrays.sort(tasks, (a, b) -> {
            int compare = Integer.compare(b[1] - b[0], a[1] - a[0]);
            if(compare == 0){
                compare = a[1] - b[1];
            }
            return compare;
        });
        for(int[] task : tasks){
            int leftover = total - cost;
            total = Math.max(total + task[1] - leftover, total);
            total = Math.max(task[1], total);
            cost += task[0];
        }
        return total;
    }
}