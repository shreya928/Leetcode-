class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k>n)return new ArrayList<>();
        solve(k, n, 1, new ArrayList<>());
        return ans;
    }
    public void solve(int k, int target, int start, List<Integer> curr){
        if(k==0 && target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(k < 0 || target < 0)return;
        for(int num = start; num <= 9; num++){
            curr.add(num);
            solve(k - 1, target - num, num + 1, curr);

            curr.remove(curr.size()-1);
        }    
    }
}