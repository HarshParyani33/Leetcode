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
                    return b.first-a.first;
                }
                return a.second - b.second;
            }
        );

        map.forEach((key,value) ->{
            pq.add(new Pair(value,key));
        });
        int[] res = new int[k];
        while(k!=0){
            res[k-1] = pq.poll().second;
            k--;
        }
        return res;
    }
}