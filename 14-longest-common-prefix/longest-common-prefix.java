class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        Arrays.sort(strs);
        int n = Math.min(strs[0].length(),strs[strs.length-1].length());
        for(int i=0; i<n; i++){
            if(strs[0].charAt(i)!=strs[strs.length-1].charAt(i)){
                return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}