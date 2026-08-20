class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f, int s){
            first = f;
            second  = s;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.first !=b.first){
                    return a.first-b.first;
                }
                return a.second - b.second;
            }
        );
        int z = k;
        map.forEach((key, value) -> {
            Pair temp = new Pair(value, key);
            
            if (pq.size() < z) {
                pq.add(temp);
            } else if (temp.first > pq.peek().first) {
                pq.poll();
                pq.add(temp);
            }
        });
        int[] res = new int[k];
        while(k!=0){
            res[k-1] = pq.poll().second;
            k--;
        }
        return res;
    }
}