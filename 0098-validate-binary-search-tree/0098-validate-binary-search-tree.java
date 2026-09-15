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
    boolean ans = true;
    TreeNode prev = null;
    public void solve(TreeNode node){
        if(node == null) return;

        solve(node.left);
        if(prev == null){
            prev = node;
        }
        else  { 
            if(node.val <= prev.val){
                ans =  false;
                return;
            }
            prev = node;
        }
        solve(node.right);
        return;

    }
    public boolean isValidBST(TreeNode root) {
        solve(root);
        return ans;
    }
}