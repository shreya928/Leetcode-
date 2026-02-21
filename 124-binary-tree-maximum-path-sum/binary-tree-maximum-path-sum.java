class Solution {
    int maxsum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxsum;
    }

    public int solve(TreeNode root) {
        if (root == null) return 0;

        int lp = Math.max(0, solve(root.left));
        int rp = Math.max(0, solve(root.right));

        int sum = lp + rp + root.val;

        maxsum = Math.max(maxsum, sum);

        return root.val + Math.max(lp, rp);
    }
}