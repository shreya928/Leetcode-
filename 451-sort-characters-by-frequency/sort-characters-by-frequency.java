class Pair{
    char ch;
    int freq;
    public Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(b.freq, a.freq)
        );
        for(Map.Entry<Character,Integer> e : hm.entrySet()){
            pq.offer(new Pair(e.getKey(),e.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            char ch = p.ch;
            int freq =  p.freq;
            while(freq!=0){
                sb.append(ch);
                freq--;
            }
        }
        return sb.toString();
    }
}