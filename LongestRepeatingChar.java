class Solution {
    public int characterReplacement(String s, int k) {
        //capital
        //k times replacing
        //sliding window
        int[] charMap = new int[26]; //only alphabets
        
        int left = 0, maxLen = 0, maxFreq = 0;
        
        for(int right = 0;right<s.length();right++){
            
            int curFreq = ++charMap[s.charAt(right) - 'A'];
            maxFreq = Math.max(maxFreq, curFreq);
            
            while((right - left + 1) - maxFreq > k){ //current length - most frequent letter's time = k (the invoking times of the switching operation)
                charMap[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right-left+1);
        }
        
        return maxLen;
        
    }
}
