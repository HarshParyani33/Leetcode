/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res = null;
    public int solve(TreeNode node , TreeNode p, TreeNode q){
        if(node== null){
            return 0;
        }
        int left = solve(node.left, p, q);
        int right  = solve(node.right, p,q);
        int self = 0;
        if(node == q || node == p){
            self =1;
        }
        int total = self + left + right;
        if(total == 2 && res == null){
            res = node;
        }
        return total;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        solve(root, p, q);
        return res;
    }
}