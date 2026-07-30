class Solution {
    public int findMin(int[] nums) {
       int n = nums.length;
       int low = 0;
       int high = n-1;
       int mid;
       int res = 0;
       int comp = nums[n-1];
       while(low<=high){
            mid = (high + low)/2;
            if(nums[mid]<=comp){
                res = nums[mid];
                high = mid-1;
            }
            else{
                low = mid+1;
            }
       } 
       return res;
    }
}