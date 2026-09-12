class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] pge = new int[n];
        int[] nge = new int[n];

        // Previous/left maximum
        pge[0] = height[0];

        for(int i = 1; i < n; i++) {
            pge[i] = Math.max(pge[i - 1], height[i]);
        }

        // Next/right maximum
        nge[n - 1] = height[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            nge[i] = Math.max(nge[i + 1], height[i]);
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            ans += Math.min(pge[i], nge[i]) - height[i];
        }

        return ans;
    }
}