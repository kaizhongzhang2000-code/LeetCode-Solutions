class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int[][] info = new int[quality.length][2];
        for(int i = 0; i < quality.length; i++){
            info[i][0] = quality[i];
            info[i][1] = wage[i];
        }
        Arrays.sort(info, (a, b) -> {
            int compare = Double.compare((double)a[1] / a[0], (double)b[1] / b[0]);
            if(compare == 0){
                compare = a[1] - b[1];
            }
            return compare;
        });
        int totalQuality = 0;
        double result = Double.MAX_VALUE;
        PriorityQueue<Integer> kSmallest = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for(int i = 0; i < info.length; i++){
            if(kSmallest.size() == k){
                totalQuality -= kSmallest.poll();
            }
            kSmallest.offer(info[i][0]);
            totalQuality += info[i][0];
            if(kSmallest.size() == k){
                double rate = (double)info[i][1] / info[i][0];
                result = Math.min(rate * totalQuality, result);
            }
        }
        return result;
    }



}