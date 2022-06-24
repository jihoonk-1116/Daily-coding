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

        //depth represents that a node is choosed in a proper order, 
        //which means a node was choosed at the correct level 
        //if there is a right node at each level, then the node is being choosed,
        //and the size of ans list will be increased as well as depth will be.
        //but if there are no a right node and even right.left node
        //then we need to look at the left sub tree
        //but traversing left sub tree is invoked at the first level
        //,where the proper node has already been added
        //Thus, we need to compare ans.size() and depth
        //in order to prevent adding an inproper node(may be left subtree's nodes) to ans
        //during left traversing 

class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int depth){
        
        if(root == null) return;
        
        if(ans.size() == depth) ans.add(root.val);
        
        dfs(root.right, depth+1);
        dfs(root.left, depth+1);
        
    }
}
