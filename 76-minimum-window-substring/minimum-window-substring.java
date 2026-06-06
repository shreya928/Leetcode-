class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(n>m || n==0 || m==0)return "";
        int hash[] = new int[256];
        for(int i=0; i<n; i++){
            hash[t.charAt(i)]++;
        }
        int cnt=0, minLen=Integer.MAX_VALUE;
        int i=0,j=0;
        int startIdx=-1;
        while(i<m){
            char ch = s.charAt(i);
            if(hash[ch]>0)cnt++;
            hash[ch]--;
            while(cnt==n){
                if(i-j+1<minLen){
                    minLen = i-j+1;
                    startIdx = j;
                }
                hash[s.charAt(j)]++;
                if(hash[s.charAt(j)]>0)cnt--;
                j++;
            } 
            i++;
        }
         return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }    
}    