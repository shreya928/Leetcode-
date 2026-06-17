class Solution {
    public int[] findpge(int nums[]){
        Stack<Integer> st = new Stack<>();
        int pge[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            pge[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
    public int[] findpse(int nums[]){
        Stack<Integer> st = new Stack<>();
        int pse[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            pse[i] = st.isEmpty()? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
    public int[] findnge(int nums[]){
        Stack<Integer> st = new Stack<>();
        int nge[] = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            nge[i] = st.isEmpty()? nums.length : st.peek();
            st.push(i);
        }
        return nge;
    }
    public int[] findnse(int nums[]){
        Stack<Integer> st = new Stack<>();
        int nse[] = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            nse[i] = st.isEmpty()? nums.length : st.peek();
            st.push(i);
        }
        return nse;
    }
    public long calmax(int nums[]){
        int pge[] = findpge(nums);
        int nge[] = findnge(nums);
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            long freq = 1L *left*right;
            sum += freq*nums[i];
        }
        return sum;
    } 
    public long calmin(int nums[]){
        int pse[] = findpse(nums);
        int nse[] = findnse(nums);
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            long freq = 1L *left*right;
            sum += freq*nums[i];
        }
        return sum;
    }   
    public long subArrayRanges(int[] nums) {
        long ans = calmax(nums) - calmin(nums);
        return ans;
    }
}