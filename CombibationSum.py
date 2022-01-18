class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        '''
        1. find integers that their sum is equal to target
        2. Result should be combination
            - In combination, order is not matter 
            (abc == acb) will not be counted
            - In permutation, order is matter     
            (abc != acb) will be counted
        3. same number can be chosen 
        4. the num of combinations is less than 150
        '''
        result = []
        
        def dfs(total, selection, path): #nested function
            if total == 0:             #found answer
                result.append(path)    #append the answer to the result 
                return
            if total < 0:              #found not answer case, then stop to invoke dfs at this step
                return
            
            for i in range(selection, len(candidates)):  #Make a choice for combination's number before invoking dfs
                dfs(total-candidates[i], i, path + [candidates[i]]) #Call dfs to make the next choice subtracting selected integer from total 
                
        dfs(target, 0, [])
        return result
