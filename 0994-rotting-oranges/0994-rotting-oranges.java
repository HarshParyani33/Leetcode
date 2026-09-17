class Solution {
    int[]x = new int[]{-1,1,0,0};
    int[]y = new int[]{0,0,-1,1};
    public boolean valid(int r, int c, int n, int m){
        if(r<0 || c<0|| r>=n || c>=m){
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                    grid[i][j] = -2;
                }
            }
        }

        while(!q.isEmpty() && fresh>0){
            time++;
            int s = q.size();
            while(s>0){
                int[] pos = q.poll();
                int r = pos[0];
                int c= pos[1];
                for(int k = 0; k<4; k++){
                    int row = r + x[k];
                    int col = c + y[k];
                    if(valid(row,col,n,m) && grid[row][col]==1){
                        q.add(new int[]{row,col});
                        fresh--;
                        grid[row][col] = -2;
                    }
                }
                s--;
            }
        }

        if(fresh>0){
            return -1;
        }
        return time;

    }
}