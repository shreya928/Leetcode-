class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        calculate(s, ans, new StringBuilder(), 0);
        return ans;
    }
    public void calculate(String s, List<String> ans, StringBuilder curr, int idx){
        if(idx == s.length()){
            ans.add(curr.toString());
            return;
        }
        char ch = s.charAt(idx);
        if(Character.isDigit(ch)){
            curr.append(ch);
            calculate(s, ans, curr, idx+1);
            curr.deleteCharAt(curr.length() - 1);
        }else{
            calculate(s, ans, curr.append(Character.toLowerCase(ch)), idx+1);
            curr.deleteCharAt(curr.length() - 1);
            calculate(s, ans, curr.append(Character.toUpperCase(ch)), idx+1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}