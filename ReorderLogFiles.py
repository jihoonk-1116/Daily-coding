#Leetcode 937

class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        
        # 2 different types of log
        # letter logs come before digit logs
        # letter logs need to be sorted by lexicographically according to their contents or identifiers
        # digit logs no need to be sorted
        
        # I would like to divide the input log into letter and digit
        # because they should be handled differently 
        
        digits , letters = [], []
        
        for log in logs:
            #Look up the contents after its identifier
            #log.split() -> dig1 8 1 5 1 , let1 art can
            #log.split()[1] -> 8 , art
            if log.split()[1].isdigit(): 
                digits.append(log)
            else:
                letters.append(log)
                
        #Sort letter logs
        #First key to sort letters list -> comparing the rest of identifier
        #Second key -> compare identifier if the two letters are same
        letters.sort(key=lambda x:(x.split()[1:], x.split()[0]))
        
      
        #merge two lists
        return letters + digits
