class Solution {
    public int findGCD(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            a = Math.max(a,nums[i]);
            b = Math.min(b,nums[i]);
        }
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}