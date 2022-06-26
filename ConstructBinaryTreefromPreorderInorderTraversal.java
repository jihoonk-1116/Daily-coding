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


//two different array expressions to represent a tree
//preoder[0] means a root of the tree
//By on the root, we can identify where right & left sub trees' elements are
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(inorder.length==0 || preorder.length==0) return null;
        if(preorder.length == 1) return new TreeNode(preorder[0]);
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int mid = 0;
        for(int i =0;i<inorder.length;i++){
            if(inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid+1), Arrays.copyOfRange(inorder,0,mid));
    
        root.right = buildTree(Arrays.copyOfRange(preorder, mid+1, preorder.length), Arrays.copyOfRange(inorder, mid+1, inorder.length));
        
        return root;
    }
    
    
}
