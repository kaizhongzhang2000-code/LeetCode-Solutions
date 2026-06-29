class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode traversal = root;
            for(int i = 0; i < word.length(); i++) {
                TrieNode node = traversal.children.getOrDefault(word.charAt(i), new TrieNode(word.charAt(i)));
                traversal.children.put(word.charAt(i), node);
                traversal = node;
                if(i == word.length() - 1) {
                    node.end = word;
                }
            }
        }
        Set<String> result = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(root, i, j, board, result);
            }
        }
        return new ArrayList<>(result);
    }

    public void dfs(TrieNode root, int i, int j, char[][] board, Set<String> result) {
        if(!root.end.equals("")) {
            result.add(root.end);
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if(board[i][j] == '#') {
            return;
        }
        if(root.children.containsKey(board[i][j])) {
            char holder = board[i][j];
            board[i][j] = '#';
            TrieNode node = root.children.get(holder);
            dfs(node, i - 1, j, board, result);
            dfs(node, i + 1, j, board, result);
            dfs(node, i, j - 1, board, result);
            dfs(node, i, j + 1, board, result);
            board[i][j] = holder;
        }
    }
}

class TrieNode {
    char val;
    Map<Character, TrieNode> children = new HashMap<>();
    String end = "";

    TrieNode() {

    }

    TrieNode(char val) {
        this.val = val;
    }
}