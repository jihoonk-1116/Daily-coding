# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#top-down approach(BFS) and pre-order
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        queue = collections.deque([root])
        
        while queue:
            node = queue.popleft() #pop parent node first
            
            if node:
                node.left, node.right = node.right, node.left
                
                queue.append(node.left)
                queue.append(node.right)
                
        return root
      
#using stack and post-order

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        stack = collections.deque([root])
        
        while stack:
            node = stack.pop()
            
            if node:
                stack.append(node.left)
                stack.append(node.right)
      
                node.left, node.right = node.right, node.left
                
                
        return root
