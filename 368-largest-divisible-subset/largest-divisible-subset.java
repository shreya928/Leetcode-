class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        int par[] = new int[n];
        int lastidx=0;
        int maxlen=1;
        Arrays.fill(dp,1);
        for(int i=0; i<n; i++){
            par[i] = i;
            for(int prev=0; prev<i; prev++){
                if(nums[prev]%nums[i]==0 || nums[i]%nums[prev]==0 && dp[prev]+1>dp[i]){
                    dp[i] = dp[prev]+1;
                    par[i] = prev;
                }
            }
            if(dp[i]>maxlen){
                maxlen = dp[i];
                lastidx = i;
            }
        }
        List<Integer> ls = new ArrayList<>();
        while(par[lastidx] != lastidx){
            ls.add(nums[lastidx]);
            lastidx = par[lastidx];
        }
        ls.add(nums[lastidx]);
        Collections.reverse(ls);
        return ls;
    }
}