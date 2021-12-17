#Find n pair's max sum of min(a,b)
#Sorted array's even index becomes max of min

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        sum =0
        nums.sort()
        for i, n in enumerate(nums):
            if i%2 ==0:
                sum += n
        return sum
      
#Python slicing approach

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        return sum(sorted(nums)[::2])
