class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g =collections.defaultdict(list)
        
        for x, y in prerequisites:
            g[x].append(y)
            
        visited = set() #mark nodes in order to reduce time complexity
        traced = set()
        
        def dfs(i):
            #if the graph is cyclic, false
            if i in traced:
                return False
            if i in visited: #check if the node was visited
                return True
            
            traced.add(i)
            for y in g[i]:
                if not dfs(y):
                    return False
            
            traced.remove(i)
            visited.add(i) #mark the node is visited
            
            return True
        
        for x in list(g):
            if not dfs(x):
                return False
            
        return True



# Time Limit Exceeded
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g =collections.defaultdict(list)
        
        for x, y in prerequisites:
            g[x].append(y)
            
        traced = set()
        
        def dfs(i):
            #if the graph is cyclic, false
            if i in traced:
                return False
            
            traced.add(i)
            for y in g[i]:
                if not dfs(y):
                    return False
            
            traced.remove(i)
            
            return True
        
        for x in list(g):
            if not dfs(x):
                return False
            
        return True
    
