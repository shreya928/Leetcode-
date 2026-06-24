class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max_count = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                count++;
                max_count = Math.max(max_count,count);
            }
            else if(ch==')')count--;
        }
        return max_count;
    }
}