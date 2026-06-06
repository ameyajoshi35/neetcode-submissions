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

        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        kSmall(root,k, pq);
        return pq.poll();
        
    }

    public void kSmall(TreeNode root, int k, PriorityQueue<Integer> pq) {

        if(root == null) return;

        kSmall(root.left,k,pq);

        pq.add(root.val);
        if(pq.size()>k) {
            pq.poll();
        }

        kSmall(root.right,k,pq);
    }
}
