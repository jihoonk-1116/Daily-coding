public class BST{

    private TreeNode root;
    
    private class TreeNode{
      
      private int Data;
      private TreeNode left;
      private TreeNode Right;
      
      
      public TreeNode(int data){
        this.data = data;
      }
    }
    public TreeNode insert(TreeNode node, int data){
        if(node == null) { //Base case : assign node
          node = new TreeNode(data);
          return node;
        }
        if(data < node.data){ //if inserted integer data is less than the current value, 
          node.left = insert(node.left, data); //then the data should be placed at the left side of the current node
        }                                      //so, invoke insert method to move to the left
        else{                 //if inserted integer data is less than the current value, 
          node.right = insert(node.right, data);  //then the data should be placed at the right side of the current node
        }                                         //so, invoke insert method to move to the right
        return node;
      }
  public void inorder(TreeNode node){ //inorder traveral (left - parent - right)
    if(node == null){
      return;
    }
    inorder(node.left);
    System.out.println(node.data);
    inorder(node.right);
  }
}
