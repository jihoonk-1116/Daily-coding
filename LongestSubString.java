/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
  */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //In order to find the longest substring without repeating characters
        //1. arr[i] != arr[i+1]
        //2. no duplicated character
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int counter=0, max=0;
        if(s.length() == 1) return 1;
        
        for(int i=0;i<s.length();i++){
            
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
                counter++;
            }
            else{
                if(counter > max) max = counter;
                i = map.get(s.charAt(i));
                map.clear();
                counter=0;
            }
        }
        if(counter > max) max = counter;
        return max;
        
    }
}

//can be improved its performance 
//Optimized version by jeantimex 
//https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812/Share-my-Java-solution-using-HashSet
