
class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        if root1 and root2:
            node = TreeNode(root1.val + root2.val)
            node.left = self.mergeTrees(root1.left, root2.left)
            node.right = self.mergeTrees(root1.right, root2.right)
            
            return node
        
        else:
            return root1 or root2
