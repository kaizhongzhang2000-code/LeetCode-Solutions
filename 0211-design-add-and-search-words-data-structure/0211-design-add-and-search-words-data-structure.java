class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode traversal = this.root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode node = traversal.children.getOrDefault(c, new TrieNode(c));
            traversal.children.put(c, node);
            traversal = node;
            if(i == word.length() - 1){
                node.hasWord = true;
            }
        }
    }
    
    public boolean search(String word) {
        TrieNode traversal = this.root;
        return dfs(word, 0, traversal);
    }

    public boolean dfs(String word, int index, TrieNode node){
        if(index == word.length()){
            return node.hasWord;
        }
        List<TrieNode> matches = new ArrayList<>();
        if(word.charAt(index) == '.'){
            matches.addAll(node.children.values());
        } else if(node.children.containsKey(word.charAt(index))){
            matches.add(node.children.get(word.charAt(index)));
        }

        for(TrieNode trie : matches){
            boolean found = dfs(word, index + 1, trie);
            if(found){
                return true;
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

 class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    char val;
    boolean hasWord = false;

    public TrieNode() {

    }

    public TrieNode(char c){
        this.val = c;
    }
 }