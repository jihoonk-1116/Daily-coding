class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        '''
        1. return all possible subsets
        2. nums' integers are unique
        3. must not contain duplicate subsets
        '''
        result = []
        
        def dfs(index, path):
            result.append(path) #every path is subset. 
                                #so append path to the result everytime to be called  
            
            for i in range(index, len(nums)): #make a selection for subset
                dfs(i+1, path + [nums[i]]) #next selection will be done from the next element, not the current one.
                
        dfs(0, []) #call dfs with the first choice
        return result
