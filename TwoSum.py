class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        num_dict = dict()   #map
        for i, num in enumerate(nums):
            num_dict[num] = i   #Numbers become key, and indeces become value
        
        for i,num in enumerate(nums):
            complement = target - num 
            if complement in num_dict and i != num_dict[complement]: #find complement as a key in the map, and not the same index
                return [i, num_dict[complement]]

 
#One for loop but same time complexity

class Solution:
    def twoSum(self, nums:List[int], target: int) -> List[int]:
        
        num_dict = dict() 
        
        for i, num in enumerate(nums):  #Iteration nums list
            complement = target - num 
            if complement in num_dict:  #Find complement in num_dict by target - nums[i] = nums[i2] 
                return [i, num_dict[complement]] #if found, return index and value of the key 
            num_dict[nums] = i #If the complement does not exist, then add it to num_dict
