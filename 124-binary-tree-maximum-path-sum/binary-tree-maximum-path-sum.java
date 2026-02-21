/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }
    public int solve(TreeNode root){
        if(root==null)return 0;
        int lh = Math.max(0,solve(root.left));
        int rh = Math.max(0,solve(root.right));
        
        int sum = lh + rh + root.val;
        ans = Math.max(ans,sum);
        return Math.max(lh,rh)+root.val;
    }
}