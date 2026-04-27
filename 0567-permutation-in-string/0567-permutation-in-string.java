class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s1.toCharArray()){
            int currFreq = freq.getOrDefault(c, 0);
            freq.put(c, currFreq + 1);
        }
        if(s1.length() > s2.length()){
            return false;
        }
        int total = s1.length();
        for(int i = 0; i < s1.length(); i++){
            if(freq.containsKey(s2.charAt(i))){
                int currFreq = freq.getOrDefault(s2.charAt(i), 0);
                if(currFreq > 0){
                    total--;
                }
                freq.put(s2.charAt(i), currFreq - 1);
            }
        }
        if(total == 0){
            return true;
        }
        int left = 0;
        int right = s1.length() - 1;
        while(right < s2.length()){
            if(right + 1 >= s2.length()){
                return false;
            }
            if(freq.containsKey(s2.charAt(left))){
                int leftFreq = freq.getOrDefault(s2.charAt(left), 0);
                if(leftFreq >= 0){
                    total++;
                }
                freq.put(s2.charAt(left), leftFreq + 1);
            }
            if(freq.containsKey(s2.charAt(right + 1))){
                int rightFreq = freq.getOrDefault(s2.charAt(right + 1), 0);
                if(rightFreq > 0){
                    total--;
                }
                freq.put(s2.charAt(right + 1), rightFreq - 1);
            }
            left++;
            right++;
            if(total == 0){
                return true;
            }
        }
        return false;
    }
}