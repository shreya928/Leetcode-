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
    int maxSum = Integer.MIN_VALUE;
    public int helper(TreeNode root){
        if(root==null)return 0;
        int ls = Math.max(0,helper(root.left));
        int rs = Math.max(0,helper(root.right));
        maxSum = Math.max(maxSum, root.val + ls + rs);
        return root.val + Math.max(ls,rs);
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
}