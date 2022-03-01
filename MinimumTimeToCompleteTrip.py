#Find minimum time to complete given trip
#Binary Search approach

class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        
        def calculate(elapsed):
            trips = 0
            for t in time:
                trips += elapsed//t
            return trips
        
        lo = 1
        hi = max(time) * totalTrips
        
        while lo < hi:
            md = lo + (hi-lo)//2
            trips = calculate(md)
            if trips < totalTrips:
                lo = md + 1
            else:
                hi = md
        return lo
