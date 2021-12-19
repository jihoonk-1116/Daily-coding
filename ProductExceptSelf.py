class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = []
        
        left_product=1
        
        for i in range(0, len(nums)):
            result.append(left_product)
            left_product = left_product * nums[i] #left_product moves to the left of the array 
                                                  #producting each number except itself
                                                  #because the variable is updated after appending
       #ex      Nums 1  2  3   4
       #left_product 1  1  1*2 1*2*3
    
    
        right_product=1
        
        for i in range(len(nums)-1, 0-1, -1): #reverse loop. right_product moves to the left of the array
            result[i] = result[i] * right_product 
            right_product = right_product*nums[i]
       #ex      Nums  1     2    3   4
       #left_product  4*3*2 4*3  4   1 
        
        return result
