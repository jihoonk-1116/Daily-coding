class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        #\w+ matches one or more word characters
        #The r means that the string is to be treated as a raw string
        #, which means all escape sequences (\n, \b) will be ignored.
        #https://stackoverflow.com/questions/26318287/what-does-r-mean-before-a-regex-pattern
        '''
        >>> print('\n') # Prints a newline character

        >>> print(r'\n') # Escape sequence is not processed
        \n
        >>> print('\b') # Prints a backspace character
        
        >>> print(r'\b') # Escape sequence is not processed
        \b
        '''
        #Module Regular Expressions (RE) specifies a set of strings (pattern) that matches it.  https://www.geeksforgeeks.org/python-regex-re-search-vs-re-findall/
        words = re.split(r'\W+',paragraph.lower())
        
        #if a word in the words is not banned one, then add the word to filtered_words
        filtered_words = [word for word in words if word not in banned]
        
        #Count each word in filtered_words
        counts = collections.Counter(filtered_words)
        
        # counts.most_common(1) 
        # return the first most common word
        # return format -> [('ball',2)]
        # Thus, return [0][0]
        return counts.most_common(1)[0][0]
