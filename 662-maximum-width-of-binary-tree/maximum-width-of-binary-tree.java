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
    class Pair{
        TreeNode node;
        int idx;
        public Pair(TreeNode node1, int idx1){
            this.node = node1;
            this.idx = idx1;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int minIdx = 0;

        while(!q.isEmpty()){
            int n = q.size();
            int first=0, last=0;

            for(int i=0; i<n; i++){
                Pair pair = q.poll();
                TreeNode node = pair.node;
                int idx = pair.idx;
                
                if(i==0)first = minIdx =  idx;
                if(i==n-1)last = idx;
                if(node.left!=null)q.offer(new Pair(node.left,(idx-minIdx)*2+1));
                if(node.right!=null)q.offer(new Pair(node.right,(idx-minIdx)*2+2));
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
    }
}