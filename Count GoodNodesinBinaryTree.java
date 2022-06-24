class Solution {
    int res = 0;
    public int goodNodes(TreeNode root) {
        if(root.left == null && root.right == null) return 1;
        dfs(root, Integer.MIN_VALUE);
        return res;
    }
    
    private void dfs(TreeNode root, int maxNum){
        
        if(root == null) return;
        
        if(root.val >= maxNum) {
            res++;
            maxNum = root.val;
        }
        
        dfs(root.left, maxNum);
        dfs(root.right, maxNum);
        
    }
}
