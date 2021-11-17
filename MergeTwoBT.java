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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //The merge rule is that if two nodes overlap, 
        //then sum node values up as the new value of the merged node. 
        //Otherwise, the NOT null node will be used as the node of the new tree.
        if(root1 == null) return root2; //if no value on tree2's node, then assign tree1's node 
        if(root2 == null) return root1; //if no value on tree1's node, then assign tree2's node
        //We do not need to cover the case that the both node is null
        
        root1.val += root2.val; //if the two nodes have a value, then assign two sum to tree1's node 
        
        root1.left = mergeTrees(root1.left, root2.left);  //traverse left side of the two trees
        root1.right = mergeTrees(root1.right, root2.right); //then, traverse right
        
        return root1;
    }
   
}
