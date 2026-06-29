class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        List<Integer> numsO = new ArrayList<>();
        List<Integer> numsE = new ArrayList<>();
        List<Integer> targetO = new ArrayList<>();
        List<Integer> targetE = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                numsE.add(nums[i]);
            } else {
                numsO.add(nums[i]);
            }

            if(target[i] % 2 == 0) {
                targetE.add(target[i]);
            } else {
                targetO.add(target[i]);
            }
        }
        Collections.sort(numsO);
        Collections.sort(numsE);
        Collections.sort(targetO);
        Collections.sort(targetE);
        long o = 0;
        long e = 0;
        for(int i = 0; i < numsO.size(); i++) {
            if(numsO.get(i) > targetO.get(i)) {
                o += numsO.get(i) - targetO.get(i);
            }
        }

        for(int i = 0; i < numsE.size(); i++) {
            if(numsE.get(i) > targetE.get(i)) {
                e += numsE.get(i) - targetE.get(i);
            }
        }
        return (o + e) / 2;
    }
}