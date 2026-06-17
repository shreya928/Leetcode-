class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length())return "0";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num.length(); i++){
            char curr = num.charAt(i); 
            while(k>0 && sb.length()!=0 && sb.charAt(sb.length()-1)>curr){
                sb.setLength(sb.length()-1);
                k--;
            }
            sb.append(num.charAt(i));
        }
         while(k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        // Remove leading zeros
        int idx = 0;
        while(idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        String ans = sb.substring(idx);

        return ans.length() == 0 ? "0" : ans;
    }
}