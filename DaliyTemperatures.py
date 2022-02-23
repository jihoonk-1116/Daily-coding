#stack approach

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        answer = [0] * len(temperatures) #initialize all answer as 0
        
        for i, cur in enumerate(temperatures):
            while stack and cur > temperatures[stack[-1]]: #if current temperature is higher than the last one.
                last = stack.pop()                         #extract the last index
                answer[last] = i - last                    #add the difference between current index and 
            
            stack.append(i)
            
        return answer 
