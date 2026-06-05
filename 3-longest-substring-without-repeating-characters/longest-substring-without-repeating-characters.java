class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        HashSet<Character> hs = new HashSet<>();
        int len = Integer.MIN_VALUE;
        int j=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            while(hs.contains(ch)){
                hs.remove(s.charAt(j));
                j++;
            }
            hs.add(ch);
            len = Math.max(len, i-j+1);
        }
        return len;
    }
}