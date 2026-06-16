class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Integer, Long> numToFreq = new HashMap<>();
        TreeMap<Long, Integer> freqToNum = new TreeMap<>();
        long[] result = new long[nums.length];
        for(int i = 0; i < freq.length; i++) {
            long f = numToFreq.getOrDefault(nums[i], 0L);
            int count = freqToNum.getOrDefault(f, 0);
            count--;
            if(count <= 0){
                freqToNum.remove(f);
            } else {
                freqToNum.put(f, count);
            }
            numToFreq.put(nums[i], f + freq[i]);
            int oldFreq = freqToNum.getOrDefault(f + freq[i], 0);
            oldFreq++;
            freqToNum.put((long)f + freq[i], oldFreq);
            result[i] = freqToNum.lastKey();
        }
        return result;
    }
}