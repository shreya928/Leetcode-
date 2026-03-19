class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int prev1 = nums[0];
        int curr = prev1;
        int prev2 = -1;
        for(int i=1; i<n; i++){
            if(i==1){
                curr = Math.max(prev1,nums[1]);
                prev2 = prev1;
                prev1 = curr;
            }else{
                curr = Math.max(prev1 ,nums[i] + prev2);
                prev2 = prev1;
                prev1 = curr;
            }
        }
        return prev1;
    }
}