class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            int compare = Integer.compare(a[0], b[0]);
            if(compare == 0){
                compare = Integer.compare(b[1], a[1]);
            }
            return compare;
        });
        List<Integer> result = new ArrayList<>();
        for(int[] envelope : envelopes){
            int length = envelope[1];
            int index = Collections.binarySearch(result, length);
            if(index < 0){
                index = - index - 1;
            }
            if(index == result.size()){
                result.add(length);
            } else {
                result.set(index, length);
            }
        }
        return result.size();
    }
}