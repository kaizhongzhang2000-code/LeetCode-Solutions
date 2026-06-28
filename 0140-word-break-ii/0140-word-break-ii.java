class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        dfs(s, wordDict, result, new StringBuilder());
        return result;
    }

    public void dfs(String s, List<String> dict, List<String> result, StringBuilder sb1) {
        if(s.isEmpty()) {
            sb1.deleteCharAt(sb1.length() - 1);

            result.add(sb1.toString());
            return;
        }
        int length1 = sb1.length();
        for(String c : dict) {
            if(s.startsWith(c)){
                sb1.append(c);
                sb1.append(" ");
                dfs(s.substring(c.length(), s.length()), dict, result, sb1);
                sb1.setLength(length1);
            }
        }
    }
}