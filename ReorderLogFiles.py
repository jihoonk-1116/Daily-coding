#Leetcode 937

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        
        digits, letters =[],[] #To store digit and letter in a log
        
        for log in logs:
            if log.split()[1].isdigit(): #log.split()[0] is identifier 
                                        #Have to use isdigit() because all input is string type
                digits.append(log)
            else:
                letters.append(log)
        
        letters.sort(key=lambda x:(x.split()[1:], x.split()[0]))
        #First key to sort letters list -> comparing the rest of identifier
        #Second key -> compare identifier if the two letters are same
        
        return letters + digits
        #merge two lists
