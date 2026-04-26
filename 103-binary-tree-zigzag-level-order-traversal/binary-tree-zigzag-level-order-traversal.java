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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         if (root == null) return new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerFirst(root);
        Boolean left = false;
        List<List<Integer>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<n; i++){
                if(!left){
                    TreeNode curr = q.pollFirst();
                    temp.add(curr.val);
                    if(curr.left!=null)q.offerLast(curr.left);
                    if(curr.right!=null)q.offerLast(curr.right);

                }else{
                    TreeNode curr = q.pollLast();
                    temp.add(curr.val);
                    if(curr.right!=null)q.offerFirst(curr.right);
                    if(curr.left!=null)q.offerFirst(curr.left);
                }
            }
            ans.add(temp);
            left=!left;
        }
        return ans;
    }
}