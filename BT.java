//10.28.21

Public class BT{
    private  Node root;
    private class Node{
        private Node right;
        private Node left;
        private int data;
        
        public Node(int data){
          this.data=data;
        }
    }
  
    public void createTree(){
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        Node fifth = new Node(5);
      
        root = first;
        root.right = second;
        root.left = third;
      
        second.left = forth;
        second.right = fifth;
        
        third.left = new Node(6);
    }
   
    public void preOrder(Node root){
        if(root == null) return //Base case
         
        System.print.out(root.data) //Print root node first
        preOrder(root.left) //Then traverse left node 
        preOrder(root.right) //Then right
    }
    public void inOrder(Node root){
       if(root == null) return //Base case
         
        inOrder(root.left) //Traverse left node first
        System.print.out(root.data) //Then print node
        inOrder(root.right) //Then right
         
        
    }
    public void postOrder(Node root){
       if(root == null) return //Base case
        
        postOrder(root.left) //Traverse left node first
        postOrder(root.right) //Then right
        System.print.out(root.data) //Print node
    }
    
    public int findMax(){
        return findMax(this.root);
    }
    
    public int findMax(Node root){
        if(root == null) return Integer.MIN_VALUE //return lowest value not to interupt comparing step.
        
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        
        if(leftMax > rightMax) return leftMax;
        else rightMax;
    }
  
}
