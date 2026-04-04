class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean prev[] = new boolean[m+1];
        prev[0] = true;
        for(int j=1; j<=m; j++){
            if(p.charAt(j-1)=='*'){
                prev[j] = prev[j-1];
            }
        }
        for(int i=1; i<=n; i++){
            boolean curr[] = new boolean[m+1];
            for(int j=1; j<=m; j++){
                char pc = p.charAt(j-1);
                char sc = s.charAt(i-1);
                if(sc == pc || pc == '?'){
                    curr[j] = prev[j-1];
                }
                else if(pc == '*'){
                    curr[j] = prev[j] || curr[j-1];
                }
                else{
                    curr[j] = false;
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}