class Solution {
    public int maxHeight(int[][] cuboids) {
        for(int[] cuboid : cuboids){
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (a, b) -> {
            int compare = a[0] <= b[0] && a[1] <= b[1] && a[2] <= b[2] ? -1 : 0;
            if(compare == 0){
                compare = a[0] >= b[0] && a[1] >= b[1] && a[2] >= b[2] ? 1 : 0;
            }
            if(compare == 0){
                compare = a[0] - b[0];
            }
            if(compare == 0){
                compare = a[1] - b[1];
            }
            if(compare == 0){
                compare = a[2] - b[2];
            }
            return compare;
        });

        int[] memo = new int[cuboids.length];
        int max = 0;
        for(int i = 0; i < cuboids.length; i++){
            int[] cuboid = cuboids[i];
            int prev = 0;
            for(int j = i - 1; j >= 0; j--){
                if(cuboid[0] >= cuboids[j][0] && cuboid[1] >= cuboids[j][1] && cuboid[2] >= cuboids[j][2]){
                    prev = Math.max(memo[j], prev);
                }
            }
            memo[i] = prev + cuboid[2];
            max = Math.max(memo[i], max);
            
        }
        return max;
    }
}