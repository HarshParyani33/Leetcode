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
    List<List<Integer>> ans = new ArrayList<>();
    public void solve(TreeNode node, int targetSum, int sum, List<Integer> res){
        if(node == null) return;
        
        sum += node.val;
        
        res.add(node.val);
        if(node.left == null && node.right == null){
            if(sum == targetSum){
                ans.add(new ArrayList<>(res));
                res.remove(res.size()-1);
                return;
            }

        }
        if(node.left != null){
            solve(node.left, targetSum, sum, res);
        }
        if(node.right != null){
            solve(node.right, targetSum, sum, res);
        }
        res.remove(res.size()-1);

        return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> res = new ArrayList<>();
        solve(root, targetSum, 0, res);
        return ans;
    }
}