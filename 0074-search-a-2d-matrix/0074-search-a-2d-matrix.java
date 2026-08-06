class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix[0].length;
        int c = matrix.length;

        int low = 0;
        int high = c-1;
        int row = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[mid][0] <=target){
                row = mid;
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        int l = 0;
        int h = r-1;
        while(l<=h){
            int guess = (l+h)/2;
            if(matrix[row][guess]<target){
                l = guess+1;

            }
            else if(matrix[row][guess]>target){
                h = guess-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}