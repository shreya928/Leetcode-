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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = inorder.length;
        for(int i=0; i<n; i++){
            map.put(inorder[i],i);
        }
        return construct(preorder, 0, preorder.length-1, inorder,0, inorder.length-1,map);
    }
    public TreeNode construct(int preorder[], int preStart, int preEnd, int inorder[],int inStart, int inEnd, HashMap<Integer,Integer> map){

        if(preStart>preEnd || inStart>inEnd)return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(preorder[preStart]);
        int numsleft = inRoot - inStart;

        root.left = construct(preorder, preStart+1, preStart + numsleft, inorder, inStart, inRoot - 1, map);
        root.right = construct(preorder, preStart+1+numsleft, preEnd, inorder, inRoot+1, inEnd, map);

        return root;
    }
}