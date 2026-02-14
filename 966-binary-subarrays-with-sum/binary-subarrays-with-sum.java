class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums, goal - 1);
    }

    public static int atmost(int[] nums, int goal){
        if (goal < 0) return 0;  // 🔥 fix

        int i = 0, ans = 0, sum = 0;

        for(int j = 0; j < nums.length; j++){
            sum += nums[j];

            while(sum > goal){
                sum -= nums[i];
                i++;
            }

            ans += j - i + 1;
        }
        return ans;
    }
}
