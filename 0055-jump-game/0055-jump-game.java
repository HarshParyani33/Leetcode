class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach = 0;
        if(n==1) return true;
        for(int i=0; i<n; i++){
            reach = Math.max(reach, i+nums[i]);
            if(reach<=i){
                return false;
            }
            
            
            if(reach==n-1){
                return true;
            }

        }
        return true;
    }
}