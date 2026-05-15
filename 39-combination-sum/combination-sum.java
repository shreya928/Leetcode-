class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        calculate(ans,curr, 0, nums, target);
        return ans;
    }
    public void calculate(List<List<Integer>> ans, List<Integer> curr, int idx, int nums[], int target){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || idx==nums.length)return;
        curr.add(nums[idx]);
        calculate(ans, curr,idx,nums, target-nums[idx]);
        curr.remove(curr.size()-1);
        calculate(ans,curr,idx+1,nums, target);
    }
}