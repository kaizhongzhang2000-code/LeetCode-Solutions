class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int index1 = -1;
        int index2 = -1;
        int[] current1 = new int[]{0, 0};
        int[] current2 = new int[]{0, 0};
        List<int[]> resultList = new ArrayList<>();
        while(index1 <= firstList.length && index2 <= secondList.length){
            int[] interval1 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
            int[] interval2 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
            if(index1 + 1 < firstList.length){
                interval1 = firstList[index1 + 1];
            }
            if(index2 + 1 < secondList.length){
                interval2 = secondList[index2 + 1];
            }
            if(index1 + 1 == firstList.length && index2 + 1 == secondList.length){
                break;
            }
            if(interval1[0] <= interval2[0]){
                index1++;
                current1 = interval1;
                if(current1[0] <= current2[1] && current2[1] != 0){
                    resultList.add(new int[]{
                        current1[0], Math.min(current2[1], current1[1])
                    });
                }
            } else if(interval2[0] <= interval1[0]){
                index2++;
                current2 = interval2;
                if(current2[0] <= current1[1] && current1[1] != 0){
                    resultList.add(new int[]{
                        current2[0], Math.min(current2[1], current1[1])
                    });
                }
            }
        }
         int[][] result = new int[resultList.size()][2];
            for(int i = 0; i < result.length; i++){
                result[i] = resultList.get(i);
            }
            return result;
    }
}