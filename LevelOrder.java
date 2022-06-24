
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            List<Integer> levelValues = new ArrayList<>();
            int size = q.size();
            
            for(int i=0;i<size;i++){
                
                TreeNode curNode = q.poll();
                
                if(curNode.left != null) q.offer(curNode.left);
                if(curNode.right != null) q.offer(curNode.right);

                levelValues.add(curNode.val);
            }
            
            
            ans.add(levelValues);
        }
        
        return ans;
    }
}
