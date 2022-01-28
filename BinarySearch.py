#Recursive solution

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def bin_search(left, right):
            if left <= right:
                mid = (left+right) // 2
                
                if nums[mid] < target:
                    return bin_search(mid+1, right)
                elif nums[mid] > target:
                    return bin_search(left, mid-1)
                else:
                    return mid
                
            else:
                return -1
            
        return bin_search(0,len(nums) -1)

#Iterative solution
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) -1
        while left <= right:
            mid = (left + right) //2
            
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                return mid
        
        return -1
