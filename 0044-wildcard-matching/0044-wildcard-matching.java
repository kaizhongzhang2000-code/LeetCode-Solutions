class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] tracker = new boolean[p.length() + 1][s.length() + 1];
        tracker[0][0] = true;
        int row = 0;
        while(row < p.length() && p.charAt(row) == '*'){
            tracker[row + 1][0] = true;
            row++;
        }
        for(int i = 1; i <= p.length(); i++){
            boolean flush = false;
            for(int j = 1; j <= s.length(); j++){
                if(flush){
                    tracker[i][j] = true;
                    continue;
                }
                if(tracker[i][0] == true){
                    flush = true;
                    tracker[i][j] = true;
                    continue;
                }
                if(p.charAt(i - 1) == '*'){
                    tracker[i][j] = tracker[i - 1][j];
                    if(tracker[i][j] == true){
                        flush = true;
                    }
                } else if(p.charAt(i - 1) == '?' || s.charAt(j - 1) == p.charAt(i - 1)){
                    tracker[i][j] = tracker[i - 1][j - 1];
                }
            }
        }
        return tracker[p.length()][s.length()];
    }
}

//  ccbab
// *11111
// b00101

//  abcab
// a10010
// *01111           
// a00010
// ?00001

//  a b a c a b a c a b
// *1 1 1 1 1 1 1 1 1 1
// b0 1 0 0 0 1 0 0 0 1
// a0 0 1 0 0 0 1 0 0 0
// c0 0 0 1 0 0 0 1 0 0
// *0 0 0 0 1 1 1 1 1 1
// c0 0 0 0 0 0 0 1 0 0
// a0 0 0 0 0 0 0 0 1 0
// b

 
// *1 1