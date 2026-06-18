class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            int curr = heights[i];
            while(!st.isEmpty() && curr < heights[st.peek()]){
                int ht = heights[st.pop()];
                int l = st.isEmpty()? -1 : st.peek();
                int r = i;
                maxArea = Math.max(maxArea, ht*(r-l-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ht = heights[st.pop()];
            int r = heights.length;
            int l = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(maxArea, ht*(r-l-1));
        }
        return maxArea;
    }
}