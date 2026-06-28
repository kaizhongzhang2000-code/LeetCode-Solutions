class Solution {
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> leftParentheses = new ArrayDeque<>();
        int[] lengthMemo = new int[s.length()];
        int longest = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                leftParentheses.push(i);
            } else {
                if(leftParentheses.size() > 0){
                    int left = leftParentheses.pop();
                    lengthMemo[i] = i - left + 1;
                    if(left - 1 >= 0){
                        lengthMemo[i] += lengthMemo[left - 1];
                    }
                    longest = Math.max(lengthMemo[i], longest);
                } 
            }
        }
        return longest;
    }
}