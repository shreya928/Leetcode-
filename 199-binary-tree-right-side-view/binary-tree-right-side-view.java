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
        int idx;
        TreeNode node;
        public Pair(int i, TreeNode n){
            this.idx = i;
            this.node = n;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root==null)return ls;
        TreeMap<Integer,TreeNode> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(0,root));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int idx = curr.idx;
            TreeNode node = curr.node;
            
            map.put(idx,node);

            if(node.left!=null){
                q.offer(new Pair(idx+1,node.left));
            }
            if(node.right!=null){
                q.offer(new Pair(idx+1, node.right));
            }
        }
        for(TreeNode n : map.values()){
            ls.add(n.val);
        }
        return ls;
    }
}