class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> sorted = new ArrayList<>();
        for(int[] row : matrix){
            for(int num : row){
                sorted.add(num);
            }
        }
        return Collections.binarySearch(sorted, target) >= 0;
    }
}