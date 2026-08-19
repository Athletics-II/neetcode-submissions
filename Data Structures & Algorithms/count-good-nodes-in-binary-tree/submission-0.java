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

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode n, int max) {
        if (n==null) return 0;

        int res = (n.val >= max) ? 1 : 0;
        max = Math.max(max, n.val);
        res+= dfs(n.left, max);
        res+= dfs(n.right, max);
        return res;
    }
}
