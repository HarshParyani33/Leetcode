class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f, int s){
            first = f;
            second =s;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Pair[] arr = new Pair[profits.length];
        for(int i=0; i<profits.length; i++){
            arr[i] = new Pair(capital[i], profits[i]);
        }
       Arrays.sort(arr, (a, b) -> Integer.compare(a.first, b.first));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        while(k>0){
            while(idx<profits.length){
                if(arr[idx].first>w){
                    break;
                }
                pq.add(arr[idx].second);
                idx++;
            }
            if(!pq.isEmpty()){
                w = w+ pq.poll();
            }else{
                break;
            }
            k--;
        }
        return w;
    }
}