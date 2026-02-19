class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        // update diameter while computing height
        diameter = Math.max(diameter, lh + rh);

        return Math.max(lh, rh) + 1;
    }
}
