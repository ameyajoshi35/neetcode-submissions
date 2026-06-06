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

 class Pair{

    TreeNode node;
    int levelMax;
    Pair(TreeNode node, int levelMax) {
        this.node = node;
        this.levelMax = levelMax;
    }
 }

class Solution {
    public int goodNodes(TreeNode root) {
        
         Queue<Pair> q = new LinkedList();

         q.add(new Pair(root,Integer.MIN_VALUE));
         int cnt = 0;

         while(!q.isEmpty()) {
             
             int size = q.size();
             for(int i =0; i< size; i++) {
                Pair pair = q.poll();
                TreeNode node = pair.node;
                int levelMax = pair.levelMax;
                
                if(node.val >= levelMax) cnt++;
                int max = Math.max(node.val, levelMax);

                if(node.left != null) {
                    
                    q.add(new Pair(node.left, max));
                    
                }
                if(node.right != null) {
                    q.add(new Pair(node.right, max));
                    
                }


             }
         }

         return cnt;
         
    }

    public int gn(TreeNode root, int max, int cnt) {
        if(root == null) {
            return cnt;
        }
        
        if(root.left != null && root.left.val > max) {
            max = Math.max(root.left.val, max);
            cnt = cnt + 1;
        }
        int left = gn(root.left, max, cnt);
        
        if(root.right != null && root.right.val > max) {
            max = Math.max(root.right.val, max);
            cnt = cnt + 1;
        }
        
        int right = gn(root.right, max, cnt);
        

        

        return left+right;
    }
}
