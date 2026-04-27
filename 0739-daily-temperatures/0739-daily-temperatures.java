class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        ArrayDeque<int[]> pendings = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            while(pendings.size() > 0 && pendings.peek()[0] < temperatures[i]){
                int[] pending = pendings.pop();
                result[pending[1]] = i - pending[1];
            }
            pendings.push(new int[]{temperatures[i], i});
        }
        while(pendings.size() > 0){
            int[] pending = pendings.pop();
            result[pending[1]] = 0;
        }
        return result;
    }
}