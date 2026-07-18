class Solution {
    public long calcHrs(int x, int piles[]){
        long totHrs = 0;
        for(int num : piles){
            totHrs += (long)Math.ceil((double)num/x);
        }
        return totHrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int n : piles){
            max = Math.max(max,n);
        }
        int ans = max;
        int l=1, r=max;
        while(l<=r){
            int mid = (l+r)/2;
            long res = calcHrs(mid,piles);
            if(res<=h){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}