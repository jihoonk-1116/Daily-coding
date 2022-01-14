#Approach 1 : Counter collection

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        freqs = collections.Counter(stones)
        count = 0
        
        for c in jewels:
            count += freqs[c]
            
        return count

#Approach 2 : Dictionary
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        freqs = {}
        count = 0
        
        for c in stones:
            if c not in freqs:
                freqs[c] = 1
            else:
                freqs[c] += 1
                
        for c in jewels:
            if c in freqs:
                count += freqs[c]
                
        return count
