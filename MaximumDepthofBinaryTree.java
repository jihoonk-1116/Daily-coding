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
    public int maxDepth(TreeNode root) {
        //find farthest leaf node
        //dfs 
        
        //invoke dfs function recursivly until reaching out to a leaf node
        //compare return value 
        
        return findLeaf(root, 0);
        
        
    }
    private int findLeaf(TreeNode node, int count){
        if(node == null){
            return count;
        }
        return Math.max(findLeaf(node.left, count+1), findLeaf(node.right, count+1));
    }
}
