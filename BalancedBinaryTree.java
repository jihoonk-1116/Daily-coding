class Solution {

    public boolean isBalanced(TreeNode root) {
        //left traverse
        //right travere
        //determine max height variable at each side
        //then compare the height
        if(root == null) return true;
    
        return dfs(root) != -1;
        
    }
    
    private int dfs(TreeNode node){
        
        if(node == null){
            return 0;
        }

        int rightHeight = dfs(node.right);
        int leftHeight = dfs(node.left);
        
        if(rightHeight == -1 || leftHeight == -1 || Math.abs(rightHeight - leftHeight) > 1){
            return -1;
        }
        
        return Math.max(rightHeight, leftHeight) + 1;
        
    }
}
