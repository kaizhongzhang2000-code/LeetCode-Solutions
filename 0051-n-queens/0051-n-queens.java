class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        dfs(0, n, new HashSet<>(), new HashSet<>(), new HashSet<>(), new ArrayList<>());
        return result;
    }

    public void dfs(int index, int n, Set<Integer> usedColumn, Set<Integer> usedDiagonal1, Set<Integer> usedDiagonal2, List<Integer> memo){
        if(index == n){
            List<String> localResult = new ArrayList<>();
            String str = "";
            for(int i = 0; i < n; i++){
                str = str + '.';
            }
            for(int i : memo){
                StringBuilder sb = new StringBuilder(str);
                sb.setCharAt(i, 'Q');
                String value = sb.toString();
                localResult.add(value);
            }
            result.add(localResult);
            return;
        }
        for(int i = 0; i < n; i++){
            if(usedColumn.contains(i) || usedDiagonal1.contains(i + n - index) || usedDiagonal2.contains(i + index)){
                continue;
            }
            usedColumn.add(i);
            usedDiagonal1.add(i + n - index);
            usedDiagonal2.add(i + index);
            memo.add(i);
            dfs(index + 1, n, usedColumn, usedDiagonal1, usedDiagonal2, memo);
            usedColumn.remove(i);
            usedDiagonal1.remove(i + n - index);
            usedDiagonal2.remove(i + index);
            memo.removeLast();
        }
        return;
    }
}