#Find three value's indics that thier summation becomes 0
#Two pointer approach : O(n^2)

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        results = []
        nums.sort() # sort by ascending order
        
        for i in range(len(nums) -2):
            if i>0 and nums[i] == nums[i-1]: #skip when the current i is the same value the previous one. Because the case is already checked before i
                continue      
            left, right = i+1, len(nums)-1 #left is always the next to the i
            while left < right:
                three_sum = nums[i] + nums[left] + nums[right]
                if three_sum > 0 : 
                    right -= 1    #Find smaller value as decrease right index
                elif three_sum < 0 :
                    left += 1     #Find greater value as increase left index
                else :
                    results.append([nums[i],nums[left], nums[right]])
                    
                    while left < right and nums[left] == nums[left+1]: #skip when the next to left is same as the current left
                        left +=1
                    while left < right and nums[right] == nums[right-1]: #skip when the next to right is same as the current right
                        right -=1
                        
                    #assign new value to the both
                    left+=1 
                    right-=1
        
        return results
