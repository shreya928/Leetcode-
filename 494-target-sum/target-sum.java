class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        for(int num:nums)totSum += num;
        if(Math.abs(target)> totSum || (totSum + target)%2 != 0)return 0;
        int newTar = (totSum + target)/2;
        int n = nums.length;
        int prev[] = new int[newTar+1];
        prev[0] = 1;
        for(int i=1; i<n+1; i++){
            int curr[] = new int[newTar + 1];
            for(int j=0; j<newTar+1; j++){
                if(nums[i-1]<=j){
                    curr[j] = prev[j-nums[i-1]] + prev[j]; 
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[newTar];
    }
}