class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[256];   // mapping s -> t
        int[] map2 = new int[256];   // mapping t -> s

        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If previous mapping doesn't match, not isomorphic
            if(map1[c1] != map2[c2]) 
                return false;

            // Mark mapping as (i+1)
            // Why i+1? Because default value is 0. We need a non-zero index.
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }

        return true;
    }
}