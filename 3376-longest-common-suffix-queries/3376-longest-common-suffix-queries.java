class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < wordsContainer.length; i++){
            indexMap.putIfAbsent(wordsContainer[i], i);
        }
        Arrays.sort(wordsContainer, (a, b) -> {
            int compare = a.length() - b.length();
            if(compare == 0){
                compare = indexMap.get(a) - indexMap.get(b);
            }
            return compare;
        });
        TrieNode root = new TrieNode();
        for(String word : wordsContainer){
            root.strings.add(word);
            TrieNode traversal = root;
            for(int i = word.length() - 1; i >= 0; i--){
                char c = word.charAt(i);
                if(traversal.children.containsKey(c)){
                    traversal = traversal.children.get(c);
                    traversal.strings.add(word);
                } else {
                    TrieNode newNode = new TrieNode(c);
                    newNode.strings.add(word);
                    traversal.children.put(c, newNode);
                    traversal = newNode;
                }
            }
        }

        int[] result = new int[wordsQuery.length];
        for(int i = 0; i < wordsQuery.length; i++){
            String query = wordsQuery[i];
            int index = query.length() - 1;
            TrieNode traversal = root;
            while(index >= 0 && traversal.children.containsKey(query.charAt(index))){
                traversal = traversal.children.get(query.charAt(index));
                index--;
            }
            result[i] = indexMap.get(traversal.strings.get(0));
        }
        return result;
    }
}

class TrieNode {
    char val;
    Map<Character, TrieNode> children = new HashMap<>();
    List<String> strings = new ArrayList<>();
    public TrieNode(){

    }

    public TrieNode(char val){
        this.val = val;
    }
}