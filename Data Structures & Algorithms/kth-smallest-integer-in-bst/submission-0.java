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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<TreeNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.val, a.val));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
            if (n.left!=null) {
                q.offer(n.left);
            }
            if (n.right!=null) {
                q.offer(n.right);
            }
        }
        
        return pq.poll().val;
    }
}
