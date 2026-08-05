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
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, Long.MIN_VALUE, Long.MAX_VALUE});
        while (!q.isEmpty()) {
            Object[] curr = q.poll();
            TreeNode node = (TreeNode)curr[0];
            long min=(long)curr[1], max=(long)curr[2];
            if (!(node.val>min && node.val<max)) return false;

            if (node.left!=null) q.offer(new Object[]{node.left, min, (long)node.val});
            if (node.right!=null) q.offer(new Object[]{node.right, (long)node.val, max});
        }

        return true;
    }
}
