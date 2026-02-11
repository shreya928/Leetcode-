class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder("");
        StringBuilder temp = new StringBuilder("");
        int i=s.length()-1;
        while (i >= 0) {
            while ( i>=0 && s.charAt(i) == ' ') {
                i--;
            }
            while (i >= 0 && s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
                i--;
            }
            if(temp.length()>0){
            ans.append(temp.reverse().toString());
            ans.append(' ');
            temp.setLength(0);
            }
        }
        if(ans.length()>0){
            ans.setLength(ans.length()-1);
        }
        return ans.toString();
    }
}