class Solution {
    public int countCommas(int n) {
        if(n<1000)return 0;
        if(n>=1000 && n<=10e5){
            return n - 1000+1;
        }
        return -1;
    }
}