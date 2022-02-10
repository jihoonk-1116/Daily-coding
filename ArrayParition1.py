#Find n pair's max sum of min(a,b)
#Sorted list's even index becomes max of min

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
       
        sum = 0
        pair = []
        nums.sort()
        
        for num in nums:
            #append two values to pair list
            pair.append(num)
            if len(pair) == 2:
                sum += min(pair) #add minimum value of pair to sum
                pair = []        #re-initialize pair list
        
        return sum

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        sum =0
        nums.sort()
        for i, n in enumerate(nums):
            if i%2 ==0: #Add only even index's value to sum because nums is sorted
                sum += n
        return sum
      
#Python slicing approach

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        return sum(sorted(nums)[::2])
