class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        int curr = nums[0];
        int prev1 = curr;
        int prev2 = -1;
        for(int i=0; i<n-1; i++){
            if(i==1){
                curr = Math.max(prev1,nums[1]);
                prev2 = prev1;
                prev1 = curr;
            }else{
                curr = Math.max(prev1, nums[i]+prev2);
                prev2 = prev1;
                prev1 = curr;
            }
        }
        int ans1 = prev1;
        curr = nums[1];
        prev1 = curr;
        prev2 = -1;
        for(int i=2; i<n; i++){
            if(i==2){
                curr = Math.max(prev1,nums[2]);
                prev2 = prev1;
                prev1 = curr;
            }else{
                curr = Math.max(prev1, nums[i]+prev2);
                prev2 = prev1;
                prev1 = curr;
            }
        }
        int ans2 = prev1;
        return Math.max(ans1,ans2);
    }
}