class Solution {
    boolean ans = true;
    public void dfs(int[][] adj, int node, int c, int[]color){
        color[node] = c;
        for(int i=0; i<adj[node].length; i++){
            int nei = adj[node][i];

            if(color[nei]!= -1 && c == color[nei]){
                ans = false;
                return;
            }
            else if(color[nei]==-1){
                dfs(adj,nei, 1-c, color);
            }
        }
        return;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[]color = new int[n];
        Arrays.fill(color, -1);
        for(int i=0; i<n; i++){
           if(color[i] == -1){
            dfs(graph,i,0,color);
           }
        }
        return ans;

    }
}