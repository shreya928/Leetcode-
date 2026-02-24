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
    static class Pair{
        int vd;
        TreeNode node;
        Pair(int h,TreeNode n){
            node = n;
            vd = h;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.offer(new Pair(0,root));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int vd = curr.vd;
            TreeNode node = curr.node;
            if(!map.containsKey(vd)){
                map.put(vd,node.val);
            }
            if(node.right!=null){
                q.offer(new Pair(vd+1,node.right));
            }
            if(node.left!=null){
                q.offer(new Pair(vd+1,node.left));
            }
        }
        for (int key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}