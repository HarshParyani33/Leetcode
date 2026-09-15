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
    TreeNode prev;
    TreeNode f1;
    TreeNode s1; 
    TreeNode f2;
    TreeNode s2;
    int g = 0;
    public void solve(TreeNode node){
        if(node== null){
            return;
        }
        solve(node.left);
        if(prev==null){
            prev= node;

        }
        else{
            if(node.val<= prev.val){
                if(g==0){
                    
                    f1 = prev;
                    s1 = node;
                    g++;
                }
                else{
                    
                    f2 = prev;
                    s2 = node;
                    g++;
                }
            }
            prev = node;
        }
        
        solve(node.right);
    }
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        int temp = 0;
        solve(root);
        if(g==1){
            temp = f1.val;
            f1.val = s1.val;
            s1.val = temp;
        } 
        else{
            temp = f1.val;
            f1.val = s2.val;
            s2.val = temp;
        }
        return;
    }
}