class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        #anagrams can be identified by sorting
        #ex) ate, eat -> sort -> both are 'aet'
        #defaultdict does not return error even when the target key is not found. Instead, it makes a new key-value mapping. 
        anagrams = collections.defaultdict(list)
        
        #Should use a word in sorted String as key 
        #the key's value becomes the original word
        #sorted() method returns a list as a result
        #So, the list needs to be converted into String by join()
        #ex 'Seperator'.join(iterable)
        
        for word in strs:
            anagrams[''.join(sorted(word))].append(word)
            
        #return all anagrams in List
        return list(anagrams.values())
