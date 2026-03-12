class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            while (!st.isEmpty() && curr < heights[st.peek()]) {
                int h = heights[st.pop()];
                int r = i;
                int l = st.isEmpty()?-1:st.peek();
                maxArea = Math.max(maxArea, h * (r - l - 1));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int h = heights[st.pop()];
            int r = n;
            int l = st.isEmpty()?-1:st.peek();
            maxArea = Math.max(maxArea, h * (r - l - 1));
        }
        return maxArea;
    }
}