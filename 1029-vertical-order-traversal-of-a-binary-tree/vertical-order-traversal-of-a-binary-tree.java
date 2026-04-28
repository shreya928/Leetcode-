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
    class Tuple{
        int row;
        int col;
        TreeNode node;
        public Tuple(int r, int c, TreeNode n){
            this.row = r;
            this.col = c;
            this.node = n;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, 0, root));
        while(!q.isEmpty()){
            Tuple tup = q.poll();
            int row = tup.row;
            int col = tup.col;
            TreeNode node = tup.node;

           if(!map.containsKey(col)){
    map.put(col,new TreeMap<>());
}
if(!map.get(col).containsKey(row)){
    map.get(col).put(row,new PriorityQueue<>());
}
map.get(col).get(row).offer(node.val);

            if(node.left!=null){
                q.offer(new Tuple(row + 1, col - 1, node.left));
            }
            if(node.right!=null){
                q.offer(new Tuple(row + 1, col + 1, node.right));
            }
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()){
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : rows.values()){
                while(!nodes.isEmpty()){
                    temp.add(nodes.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}