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
    TreeNode res = null;
    public void solve(TreeNode node, int val){
        if(node == null){
            return;
        }
        if(node.val == val){
            res = node;
        }
        else if(node.val < val){
            solve(node.right, val);
        }
        else{
            solve(node.left, val);
        }

    }
    public TreeNode searchBST(TreeNode root, int val) {
        solve(root, val);
        return res;
    }
}