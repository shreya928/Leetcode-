class Solution {
    public String reverseWords(String s) {
        String str = s.trim();
        StringBuilder sb = new StringBuilder("");
        int i=str.length()-1;
        while(i>=0){
            StringBuilder temp = new StringBuilder(""); 
            while(i>=0 && str.charAt(i)!=' '){
                temp.append(str.charAt(i));
                i--;
            }
            temp.reverse();
            temp.append(' ');
            sb.append(temp);
            while( i>=0 && str.charAt(i)==' ')i--;
        }
        return sb.toString().trim();
    }
}