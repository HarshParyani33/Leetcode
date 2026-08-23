class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        int seat = 0;
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> p1 = pq.poll();
            if(sb.length()==0 || sb.charAt(seat-1) != p1.getKey()){
                sb.append(p1.getKey());
                int rem = p1.getValue()-1;
                if (rem > 0) {
                p1.setValue(rem);
                pq.add(p1);
                }
                seat++;
            }
            else{
                if(pq.isEmpty()) return "";
                Map.Entry<Character,Integer> p2 = pq.poll();
                sb.append(p2.getKey());
                seat++;
                int rem = p2.getValue()-1;
                if (rem > 0) {
                    p2.setValue(rem);
                    pq.add(p2);
                }
                pq.add(p1);
                
            }
        }
        return sb.toString();
    }
}