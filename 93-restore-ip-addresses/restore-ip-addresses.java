class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        solve(s,0,0,"");
        return ans;
    }
    public void solve(String s, int idx, int parts, String curr){
        if(parts==4 && idx==s.length()){
            ans.add(curr.substring(0, curr.length()-1));
            return;
        }
        if(parts>4)return;
        for(int len=1; len<4; len++){
            if(idx+len>s.length())break;
            String part = s.substring(idx, idx+len);
            if(part.length()>1 && part.charAt(0)=='0')continue;
            int val = Integer.valueOf(part);
            if(val<=255){
                solve(s, idx+len, parts+1, curr+part+".");
            }
        }
    }
}