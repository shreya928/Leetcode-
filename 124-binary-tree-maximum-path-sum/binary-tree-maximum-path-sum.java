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
        int ls = helper(root.left);
        int rs = helper(root.right);
        if(ls<0)ls=0;
        if(rs<0)rs=0;
        int currSum = ls + rs + root.val;
        maxSum = Math.max(maxSum, currSum);
        return Math.max(ls,rs) + root.val;
    }
    public int maxPathSum(TreeNode root) {
         helper(root);
         return maxSum;
    }
}