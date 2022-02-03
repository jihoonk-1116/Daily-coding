#From https://leetcode.com/problems/find-substring-with-given-hash-value/discuss/1730686/Python-O(N)-Time-Backward-Sliding-Window-with-Detailed-Explanation
#By magua-io

class Solution:
    def subStrHash(self, s: str, power: int, modulo: int, k: int, hashValue: int) -> str:
        '''
        Use Sliding window and rolling hash to find the first substring 
        that has same hash value as provided `hashValue`.
        
        Time: O(n)
        Space: O(n)
        '''
        
        # generate val list for each letter
        vals = [ord(c) - ord('a') + 1 for c in s]
        
        # gradually build `powers` by multiply `power` instead of using `**`
        # which is very slow and will cause TLE.
        # Or use pow(x, y, z). Ref: https://docs.python.org/3/library/functions.html#pow
        
        # powers = [1] * k
        # for i in range(1, k):
        #     powers[i] = (powers[i-1] * power) % modulo
        powers = [pow(power, i, modulo) for i in range(k)]
        
        n = len(s)
        # initial hash_value for the last substring with length n
        hash_value = sum(vals[n - k + i] * powers[i] for i in range(k))
        # set idx with the beginning of the last substring with length n
        idx = n - k
        # moving backwards to calculate new hash value
        # because moving backwards you can just `* power`
        # moving forward will involve `//`, which is difficult for modulo
        for i in range(n-k-1, -1, -1):
            # update hash_value by removing the last index (i+k), 
            # and multiply the rest by power since each remaining characters' indices increase by 1 for new substring
            # and add the newcoming vals[i] * powers[0] (which is 1 and could be omitted)
            hash_value = ((hash_value - vals[i+k] * powers[k-1]) * power + vals[i] ) % modulo
            # keep updating idx since we are moving to the left
            # and trying to find the first substring that has the same hash value as `hashValue`
            if hash_value == hashValue:
                idx = i
        return s[idx:idx+k]
