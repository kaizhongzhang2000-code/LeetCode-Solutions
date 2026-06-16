class Solution {
    public String minWindow(String s, String t) {
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            int f = freq.getOrDefault(t.charAt(i), 0);
            f++;
            freq.put(t.charAt(i), f);
        }
        int total = t.length();
        int shortest = Integer.MAX_VALUE;
        String result = "";
        for(int i = 0; i < s.length(); i++){
            if(!freq.containsKey(s.charAt(i))) {
                continue;
            }
            int f = freq.get(s.charAt(i));
            f--;
            freq.put(s.charAt(i), f);
            if(f < 0) {
                while(queue.size() > 0 && freq.get(queue.peek().getKey()) < 0) {
                    Map.Entry<Character, Integer> pair = queue.poll();
                    char c = pair.getKey();
                    int cf = freq.get(c);
                    cf++;
                    freq.put(c, cf);
                }

            } else {
                total--;
            }
            queue.offer(Map.entry(s.charAt(i), i));
            if(total == 0){
                if(i - queue.peek().getValue() + 1 < shortest) {
                    result = s.substring(queue.peek().getValue(), i + 1);
                    shortest = result.length();
                }
            }
        }
        return result;
    }
}
