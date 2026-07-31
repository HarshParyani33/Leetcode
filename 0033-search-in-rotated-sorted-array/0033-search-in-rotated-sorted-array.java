class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int lowest = 0;
        int comp = nums[high];
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid]>comp){
                low = mid+1;
            }
            else{
                lowest = mid;
                high = mid-1;
            }
        }
        low = 0;
        high =nums.length-1;
        if(target<comp){
            return BinarySe(lowest, high, nums, target);
        }
        else if(target>comp){
            return BinarySe(low, lowest-1, nums, target);
        }
        return nums.length-1;
    }
    public int BinarySe(int l, int h, int[]nums, int k){
        int m ;
        while(l<=h){
            m = (l+h)/2;
            if(nums[m] == k){
                return m;
            }
            else if(nums[m]<k){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return -1;

    }
}