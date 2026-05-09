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
                    return b.str.compareTo(a.str); // lexicographically larger first
                }
                return Integer.compare(a.val, b.val); // lower  freq first
            }
        );
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for(Map.Entry<String,Integer> e : map.entrySet()){
            pq.offer(new Pair(e.getKey(),e.getValue()));
            if(pq.size()>k)pq.poll();
        }
        List<String> ls = new ArrayList<>();
        while(!pq.isEmpty()){
            ls.add(pq.poll().str);
            k--;
        }
        Collections.reverse(ls);
        return ls;
    }
}