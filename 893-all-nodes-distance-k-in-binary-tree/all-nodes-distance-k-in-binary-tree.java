/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        markParent(root, parent);
        HashMap<TreeNode,Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.offer(target);
        vis.put(target,true);
        while(!q.isEmpty()){
            int n = q.size();
            if(level==k)break;
            level++;
            for(int i=0; i<n; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && !vis.containsKey(curr.left)){
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && !vis.containsKey(curr.right)){
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
                if(parent.containsKey(curr) && !vis.containsKey(parent.get(curr))){
                    q.offer(parent.get(curr));
                    vis.put(parent.get(curr),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ans.add(node.val);
        }
        return ans;
    }
}