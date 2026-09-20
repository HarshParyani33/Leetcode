class Solution {
    class Pair{
        int des;
        int cost;
        Pair(int d, int c){
            des = d;
            cost =c;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++){
            int src = times[i][0] -1;
            int des = times[i][1] -1;
            int cost = times[i][2];
            adj.get(src).add(new Pair(des,cost));
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> {
            return a.cost - b.cost;
        });
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0;
        heap.add(new Pair(k-1, 0));

        while(!heap.isEmpty()){
            Pair curr = heap.poll();
            int s = curr.des;
            int c = curr.cost;
            if(c>dist[s]) continue;
            for(int i=0; i<adj.get(s).size(); i++){
                Pair p = adj.get(s).get(i);
                int nei = p.des;
                int wt = p.cost;
                if(c+wt<dist[nei]){
                    dist[nei] = c+wt;
                    heap.add(new Pair(nei,c+wt));
                } 
            }
        }
        int max = 0;
        for(int i=0; i<n; i++){
            if(dist[i]>max){
                max = dist[i];
            }
        }
        if(max == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return max;
        }

    }
}