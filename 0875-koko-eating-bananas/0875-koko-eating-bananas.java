class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high =0;
        for(int i=0; i<piles.length; i++){
            if(high<piles[i]) high = piles[i];
        }
        int res = -1;
        while(low<=high){
            int mid = (low+high)/2;
            long hours = fun(piles, piles.length, mid);
            if(hours>h){
                low = mid+1;
            }
            else{
                res = mid;
                high = mid -1;
            }
        }
        return res;
    }
    public long fun(int[]piles, int n, int guess){
        long z = 0;
        for(int i=0; i<n; i++){
            z = z + piles[i]/guess;
            if(piles[i]%guess !=0){
                z++;
            }
        }
        return z;
    }
}