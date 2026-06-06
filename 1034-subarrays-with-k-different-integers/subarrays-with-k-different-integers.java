class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k-1);
    }
    public int atmost(int nums[], int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int j=0, ans=0;
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
            while(hm.size()>k){
                if(hm.get(nums[j])==1){
                    hm.remove(nums[j]);
                }else{
                    hm.put(nums[j], hm.get(nums[j])-1);
                }
                j++;
            }
            ans += i - j + 1;
        }
        return ans;
    }
}