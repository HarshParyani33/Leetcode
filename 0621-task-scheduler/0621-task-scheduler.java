class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map2 = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b.getValue(), a.getValue());
        });
        int pos = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<tasks.length; i++){
            char ch = tasks[i];
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            map2.put(ch, map2.getOrDefault(ch,0)+1);

        }

        pq.addAll(map2.entrySet());
        while(!pq.isEmpty()){
           ArrayList<Map.Entry<Character, Integer>> free = new ArrayList<>();
           while(!pq.isEmpty()){
            Map.Entry<Character, Integer> p1 = pq.poll();
            char ch= p1.getKey();
            int freq = p1.getValue();
            if(map.get(ch)<=pos){
                if(map2.get(ch)>1){
                    p1.setValue(freq-1);
                    pq.add(p1);
                }
                else{
                    map2.put(ch, 0);
                }
                map.put(ch,pos+n+1);
                break;
            }else{
                free.add(p1);

            }
           }
           for(int i=0; i<free.size(); i++){
            pq.add(free.get(i));
           }
           pos++;
        }
    
        return pos-1;
    }
}