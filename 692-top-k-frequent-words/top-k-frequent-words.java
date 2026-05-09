class Solution {
    class Pair{
        String str;
        int val;
        public Pair(String str,int val){
            this.str = str;
            this.val = val;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.val == b.val) {
                    return a.str.compareTo(b.str); // lexicographically smaller first
                }
                return Integer.compare(b.val, a.val); // higher freq first
            }
        );
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for(Map.Entry<String,Integer> e : map.entrySet()){
            pq.offer(new Pair(e.getKey(),e.getValue()));
        }
        List<String> ls = new ArrayList<>();
        while(k>0){
            Pair p = pq.poll();
            ls.add(p.str);
            k--;
        }
        return ls;
    }
}