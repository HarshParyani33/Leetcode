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
    public void fun(TreeNode node,List<Integer> res ){
        if(node == null){
            return;
        }
        fun(node.left,res);
        fun(node.right,res);
        res.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=  new ArrayList<>();
        fun(root,res);
        return res;
    }
}