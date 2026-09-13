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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean n = false;
        if(root == null) return true;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t= q.poll();
            if(t== null){
                n = true;
            }
            else{
                if(n == true) return false;
                q.add(t.left);
                q.add(t.right);
            }
        }
        return true;
    }
}