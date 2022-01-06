class Solution:
    def isValid(self, s: str) -> bool:
        stack = list()
        #mapping table
        table = {
            ')':'(',
            '}':'{',
            ']':'[',
        }
        
        for c in s:
            if c not in table: #find c as a key 
                stack.append(c) #c is not key then append to the stack
            elif not stack or table[c] != stack.pop(): #if the stack is empty 
                                                       #or the value mapping to c is not equal to the last inserted element of the stack
                return False                           #return false
        
        return len(stack)==0 #if the stack is empty after the loop -> true
