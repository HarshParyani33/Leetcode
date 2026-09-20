class Solution {
    public boolean valid(int r,int c,  int n,int m){
        if(r<0 || c<0 || r>=n ||  c>=m){
            return false;
        }
        return true;
    }
    class Pair{
        int first ;
        int second;
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] res = new int[n][m];
        for (int[] row : res) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            return a[0] -b[0];
        });
        int[]x = new int[]{-1,1,0,0};
        int[] y = new int[]{0,0,-1,1};
        res[0][0] = 0;
        heap.add(new int[]{0,0,0});
        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            int dis = curr[0];
            int row = curr[1];
            int col = curr[2];
            if(dis>res[row][col]) continue;
            for(int k=0; k<4; k++){
                int r = row+x[k];
                int c = col+y[k];
                if(!valid(r,c,n,m)) continue;
                int d = Math.abs(heights[row][col] - heights[r][c]);
                int newwt = Math.max(dis,d);
                if(newwt<res[r][c]){
                    res[r][c] = newwt;
                    heap.add(new int[]{newwt, r,c});
                }
            }

        }
        return res[n-1][m-1];
    }
}