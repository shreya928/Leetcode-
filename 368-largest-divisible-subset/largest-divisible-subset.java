class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxlen = 1;
        int lastidx = 0;
        int dp[] =new int[n];
        int parent[] = new int[n];
        Arrays.fill(dp,1);
        for(int i=0; i<n; i++){
            parent[i] = i;
            for(int prev=0; prev<i; prev++){
                if(nums[i]%nums[prev]==0 && dp[prev]+1>dp[i]){
                    dp[i] = dp[prev] + 1;
                    parent[i] = prev;
                }
            }
            if(dp[i]>maxlen){
            maxlen = dp[i];
            lastidx = i;
        }
        }
        ArrayList<Integer> ls = new ArrayList<>();
        while(parent[lastidx]!=lastidx){
            ls.add(nums[lastidx]);
            lastidx = parent[lastidx];
        }
        ls.add(nums[lastidx]);
        Collections.reverse(ls);
        return ls;
    }
}