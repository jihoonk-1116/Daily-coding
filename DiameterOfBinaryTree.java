class Solution {
    
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    
    private int dfs(TreeNode node){
        
        if(node == null){
            return 0; 
        }
        
        //left traverse
        int left = dfs(node.left);
        //right traverse
        int right = dfs(node.right);
        //update diameter
        diameter = Math.max(diameter, right + left);
        //return 
        return Math.max(right, left) + 1;
    }

}
