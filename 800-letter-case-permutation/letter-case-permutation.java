class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        String curr = "";
        calculate(s, ans, curr, 0);
        return ans;
    }
    public void calculate(String s, List<String> ans, String curr, int idx){
        if(idx == s.length()){
            ans.add(curr);
            return;
        }
        char ch = s.charAt(idx);
        if(Character.isDigit(ch)){
            calculate(s, ans, curr+ch, idx+1);
        }else{
            calculate(s, ans, curr + Character.toLowerCase(ch), idx+1);
            calculate(s, ans, curr + Character.toUpperCase(ch), idx+1);
        }
    }
}