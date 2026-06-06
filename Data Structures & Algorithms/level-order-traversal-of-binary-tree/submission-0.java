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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList();

        q.add(root);
        List<Integer> level = new ArrayList();
        level.add(root.val);

        while(!q.isEmpty()) {
            
            int size = q.size();
            
            ans.add(new ArrayList(level));
            level = new ArrayList();
            

            for(int i=0; i< size;i++) {
                TreeNode node = q.poll();                
                if(node.left != null) {
                    q.add(node.left);
                    level.add(node.left.val);
                }
                if(node.right != null) {
                    q.add(node.right);
                    level.add(node.right.val);
                }

            }
        }

        return ans;
        
    }
}
