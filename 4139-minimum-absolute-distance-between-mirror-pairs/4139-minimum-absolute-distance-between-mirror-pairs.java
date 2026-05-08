class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> pos = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(pos.containsKey(nums[i])){
                int prev = pos.get(nums[i]);
                min = Math.min(i - prev, min);
            }
            pos.put(reverse(nums[i]), i);
        }
        return min < Integer.MAX_VALUE ? min : -1;
    }

    public int reverse(int num){
        int power = 1;
        int result = 0;
        List<Integer> digits = new ArrayList<>();
        while(num > 0){
            int digit = num % 10;
            num = num / 10;
            digits.add(digit);
        }
        Collections.reverse(digits);
        for(int digit : digits){
            result += digit * power;
            power = power * 10;
        }
        return result;
    }
}