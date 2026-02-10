// class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> st = new Stack<>();
//         for(int i=0; i<s.length(); i++){
//             char ch = s.charAt(i);
//             if(st.isEmpty()){
//                 st.push(ch);
//             }else if(ch==')' && st.peek()=='('){
//                 st.pop();
//             }else{
//                 st.push(ch);
//             }
//         }
//         return st.size();
//     }
// }
class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int closeCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') openCount++;
            else {
                if(openCount > 0) openCount--;
                else closeCount++;
            }
        }
        return openCount + closeCount;
    }
}