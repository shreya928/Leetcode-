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
 class Tuple{
    int col;
    int row;
    TreeNode node;
    public Tuple(int c, int r, TreeNode n){
        this.col = c;
        this.row = r;
        this.node = n;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0,0,root));
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                Tuple t = q.poll();
                int prow = t.row;
                int pcol = t.col;
                TreeNode node = t.node;
                if (!map.containsKey(pcol)) {
                    map.put(pcol, new TreeMap<>());
                }
                if (!map.get(pcol).containsKey(prow)) {
                    map.get(pcol).put(prow, new PriorityQueue<>());
                        
                }
                map.get(pcol).get(prow).offer(node.val);
                if(node.left!=null)q.offer(new Tuple(pcol-1,prow+1,node.left));
                if(node.right!=null)q.offer(new Tuple(pcol+1,prow+1,node.right));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> rows : map.values()){
            List<Integer> ls = new ArrayList<>();
            for(PriorityQueue<Integer> pq : rows.values()){
                while(!pq.isEmpty()){
                    ls.add(pq.poll());
                }
            }
            ans.add(ls);
        }
        return ans;
    }
}