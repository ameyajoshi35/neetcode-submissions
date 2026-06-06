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
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        


        rLN(null, root,target);
        if(root.val==target && root.left==null && root.right==null) return null;

        return root;



        
    }

    public void rLN(TreeNode parent, TreeNode root, int target){
        if(root == null) return;

        rLN(root, root.left, target);
        rLN(root, root.right, target);

        // Check if left child is a leaf
        if (root.left != null && 
            root.left.left == null && 
            root.left.right == null && root.left.val == target) {
            
            System.out.println("Left leaf: " + root.left.val);
            root.left = null;
        }

        // Check if right child is a leaf
        if (root.right != null && 
            root.right.left == null && 
            root.right.right == null && root.right.val == target) {
            
            System.out.println("Right leaf: " + root.right.val);
            root.right = null;
        }

        return;
    }
}