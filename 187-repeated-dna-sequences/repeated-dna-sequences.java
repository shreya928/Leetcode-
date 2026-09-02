class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> hm = new HashMap<>();
        if(s.length()<10)return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for(int i=0; i<s.length()-10+1; i++){
            String str = s.substring(i,i+10);
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        for(Map.Entry<String, Integer> e : hm.entrySet()){
            String key = e.getKey();
            Integer val = e.getValue();
            if(val>1)ans.add(key);
        }
        return ans;
    }
}