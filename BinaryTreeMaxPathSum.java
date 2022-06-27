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
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        
        if(root == null) return 0;
        
        //get left & right values
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        //compare 4 cases
        int maxChild = Math.max(left, right);
        int maxWithChild = Math.max(root.val, root.val + maxChild);
        int maxOfAll= Math.max(maxWithChild, root.val + left + right);

        //compare curMax and prev one
        res = Math.max(res, maxOfAll);
        
        //return maxSum with one node
        return maxWithChild;
    }
}
