class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int dp[] = new int[n+1];
        int maxlen = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            String str = words[i];
            int best = 1;
            for(int j=0; j<str.length(); j++){
                String s = str.substring(0,j) + str.substring(j+1);
                if(hm.containsKey(s)){
                    best = Math.max(best, hm.get(s)+1);
                }
            }
            hm.put(str, best);
            maxlen = Math.max(maxlen, best);
        }
        return maxlen;
    }
}