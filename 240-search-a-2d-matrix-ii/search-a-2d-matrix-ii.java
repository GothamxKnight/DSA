class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int []arr:matrix){
            for(int a:arr){
                if(a==target){
                    return true;
                }
            }
        }
        return false;
    }
}