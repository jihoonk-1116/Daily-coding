#Find three values that their summation becomes 0
#Two pointer approach : O(n^2)
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        #Three sum = 0
        #return triplets in list
        #1. Sort nums
        #2. Iterate nums with i 
        #3. Nested loop with left that starts i+1 and right that begins len(nums)-1
        
        result = []
        nums.sort() #inplace sorting in ascending order
        
        for i in range(len(nums)-2):
            #Skip when the next i is same as the previous one
            if i > 0 and nums[i] == nums[i-1]:
                continue 
            left , right = i+1, len(nums)-1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                #if sum is less than 0, then it needs to be increased
                #So, move left because nums is already sorted
                if sum < 0:
                    left += 1
                    
                #if sum is greater than 0, then it needs to be decreased
                #So, move right because nums is already sorted
                elif sum > 0:
                    right -= 1
                    
                #if a triplet is found
                else:
                    #append it to result list
                    result.append([nums[i],nums[left], nums[right]])
                    
                    #Skip the next left value when the current left's value is equal to the next one, and right pointer too.
                    while left<right and nums[left] == nums[left+1]:
                        left += 1
                    while left < right and nums[right] == nums[right-1]:
                        right -= 1
                    
                    left += 1
                    right -= 1
            
        return result
        
        
