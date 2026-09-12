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
    Stack<TreeNode> as = new Stack<>();
    Stack<TreeNode> des = new Stack<>();
    public int small(){
        TreeNode sm= as.pop();
        TreeNode right = sm.right;
        while(right != null){
            as.push(right);
            right = right.left;

        }
        return sm.val;
    }
     public int bigNum(){
        TreeNode big= des.pop();
        TreeNode leftN = big.left;
        while(leftN != null){
            des.push(leftN);
            leftN = leftN.right;

        }
        return big.val;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        TreeNode t= root;
        while(t != null){
            des.push(t);
            t = t.right;
        }
        t = root;
        while(t !=null){
            as.push(t);
            t = t.left;
        }
        int s = small();
        int b = bigNum();
        while(s<b){
            if(s+b == k){
                return true;
            }
            else if(s+b<k){
                s = small();
            }
            else{
                b = bigNum();

            }
        }
        return false;
    }
}