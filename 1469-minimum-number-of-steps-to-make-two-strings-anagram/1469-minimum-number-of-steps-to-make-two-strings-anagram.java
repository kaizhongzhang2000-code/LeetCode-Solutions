class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for(char sChar : s.toCharArray()){
            count[sChar - 'a'] ++;
        }
        for(char tChar : t.toCharArray()){
            count[tChar - 'a'] --;
        }
        int result = 0;
        for(int countNum : count){
            if(countNum > 0){
                result += countNum;
            }
        }
        return result;
    }
}