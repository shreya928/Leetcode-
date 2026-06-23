class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0, i = 0, maxlen = Integer.MIN_VALUE;
        for(int j=0; j<nums.length; j++){
            if(nums[j]==0)count++;
            while(count>k){
                if(nums[i]==0)count--;
                i++;
            }
            maxlen = Math.max(maxlen, j-i+1);
        }
        return maxlen;
    }
}