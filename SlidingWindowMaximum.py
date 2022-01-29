class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        deq, ans = deque(), []

        for i in range(len(nums)):
           
            if deq and i-deq[0] == k:
                deq.popleft()

            
            while deq and nums[deq[-1]] <= nums[i]:
                deq.pop()

            deq.append(i) 
         
            if i+1 >= k:
                ans.append(nums[deq[0]])

        return ans
      
 # https://www.youtube.com/watch?v=DfljaUwZsOk

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return []
        
        n=len(nums)
        dq=deque() # contains indices
        res=[]
        
        for i in range(n):
            while dq and dq[0]==i-k:
                dq.popleft()
            while dq and nums[dq[-1]]<nums[i]:
                dq.pop()
            dq.append(i)
            if i>=k-1:
                res.append(nums[dq[0]])

        return res
