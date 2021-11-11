public class Tree {
	public TreeNode root;
	
	private class TreeNode{
		
		private int data;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int value) {
			this.data = value;
		}
		
	}
	public void insert(int value) {
		root = insertNode(root, value);
	}
	
	public TreeNode insertNode(TreeNode root, int value){
		if(root == null) { 			//Base case : assign node
			root = new TreeNode(value);
			return root;
		}
		if(root.data > value) { 		//if inserted integer data is less than the current value, 
			root.left=insertNode(root.left, value); //then the data should be placed at the left side of the current node
		}						//so, invoke insert method to move to the left
		else 						//if inserted integer data is less than the current value, 
			root.right = insertNode(root.right, value);  //then the data should be placed at the right side of the current node
		 						//so, invoke insert method to move to the right
		return root;
		
	}
	
	public void searchByKey(int key) {
		TreeNode temp = searchByKey(this.root, key);
		if(temp == null) System.out.println("Not found...");
		else System.out.println("Found! : " + temp.data);
		
	}
	private TreeNode searchByKey(TreeNode tn, int key){
        if(tn == null || tn.data == key) return tn; //base case
        
        if(key < tn.data) return searchByKey(tn.left, key); //Search left in order to finding the value that is less than root
        else return searchByKey(tn.right, key); 	    //Search right in order to finding the value that is bigger than root
                                     
    }
	public void inorder(TreeNode root) { //left -> root > right
		if(root == null) return;
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
		
	}
	public static void main(String[] args) {
		Tree bst = new Tree();
		bst.insert(4);
		bst.insert(2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(5);
		bst.insert(6);
		bst.inorder(bst.root);
		bst.searchByKey(0);
	}
}
