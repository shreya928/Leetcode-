class Pair{
    int num;
    int freq;
    public Pair(int n, int f){
        this.num = n;
        this.freq = f;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->(a.freq-b.freq)
        );
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
            pq.offer(new Pair(e.getKey(),e.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int i=0;
        while(!pq.isEmpty()){
            ans[i]=pq.poll().num;
            i++;
        }
        return ans;
    }
}