class Solution {
    public int numberOfSubstrings(String s) {
        long n = s.length();
        long totSubstring = n*(n+1)/2;
        HashMap<Character, Integer> hm = new HashMap<>();
        int j=0, ans = 0;
        for(int i=0; i<n; i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0)+1);
            while(hm.size()>2){
                if(hm.get(s.charAt(j))==1){
                    hm.remove(s.charAt(j));
                }else{
                    hm.put(s.charAt(j),hm.get(s.charAt(j))-1);
                }
                j++;
            }
            ans += i - j + 1;
        }
        long final_ans = totSubstring - (long)ans;
        return (int)final_ans;
    }
}