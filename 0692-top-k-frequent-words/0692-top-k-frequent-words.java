
class Solution {
    class Pair{
        int first;
        String second;

        Pair(int f, String s){
            first = f;
            second =s;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<Pair> pq  = new PriorityQueue<>(
            (a,b) ->{
                if(a.first!= b.first){
                    return b.first - a.first;
                }
                return a.second.compareTo(b.second);
            }
        );

        map.forEach((key, value) ->{
            pq.add(new Pair(value, key));
        });
        List<String> res = new ArrayList<>();
        while(k!=0){
            res.add(pq.poll().second);
            k--;
        }
        return res;
    }
}