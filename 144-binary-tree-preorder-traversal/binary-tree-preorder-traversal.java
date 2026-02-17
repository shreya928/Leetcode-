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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        helper(root,ls);
        return ls;
    }
    public void helper(TreeNode root, List<Integer> ls){
        if(root==null){
            return;
        }
        ls.add(root.val);
        helper(root.left,ls);
        helper(root.right,ls);
    }
}