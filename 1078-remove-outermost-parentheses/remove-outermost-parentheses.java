class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder("");
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
            }else{
                if(ch==')'){
                    st.pop();
                }else{
                    st.push(ch);
                }
                if(!st.isEmpty())sb.append(ch);
            }
        }
        return sb.toString();
    }
}