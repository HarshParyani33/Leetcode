class Solution {
    class Pair{
        int[] first;
        double second;
        Pair(int[]f , double s){
            first = f;
            second =s;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                return Double.compare(b.second, a.second);
                
            }
        );
        for(int i=0; i<points.length;i++){
            int[] p = points[i];
            Pair temp = dist(p);
            if(pq.size()<k){
                pq.add(temp);

            }
            else if(temp.second <pq.peek().second){
                pq.poll();
                pq.add(temp);
            }
        }
        int[][]res = new int[k][2];
        for(int i=0; i<k; i++){
                res[i] = pq.poll().first;
                
        }
        return res;
    }
    public Pair dist(int[]p){
        double dist = Math.sqrt(p[0]*p[0] + p[1]*p[1]);

        return new Pair(p,dist);
    }
}