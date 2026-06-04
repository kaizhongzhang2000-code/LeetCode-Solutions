class Solution {
    int max = 0;
    public int maxJumps(int[] arr, int d) {
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);
        for(int i = 0; i < arr.length; i++){
            dfs(arr, d, memo, i);
        }
        return max;
    }

    public int dfs(int[] arr, int d, int[] memo, int index){
        if(memo[index] >= 0){
            return memo[index];
        }
        int curr = 0;
        int left = index - 1;
        while(left >= Math.max(0, index - d) && arr[left] < arr[index]){
            curr = Math.max(curr, dfs(arr, d, memo, left));
            left--;
        }
        int right = index + 1;
        while(right < Math.min(arr.length, index + d + 1) && arr[right] < arr[index]){
            curr = Math.max(curr, dfs(arr, d, memo, right));
            right++;
        }
        memo[index] = curr + 1;
        if(memo[index] > max){
            max = memo[index];
        }
        return memo[index];
    }
}