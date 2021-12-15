class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_dict = dict()   #map
        for i, num in enumerate(nums):
            num_dict[num] = i   #Numbers become key, and indeces become value
        
        for i,num in enumerate(nums):
            complement = target - num 
            if complement in num_dict and i != num_dict[complement]: #find complement as a key in the map, and not the same index
                return [i, num_dict[complement]]
