/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

*/


class Solution {
    public String reverseWords(String s) {
        //use two pointers
        //check space or not or the end of an array
        //use whitespace -1 or +1 indices to reverse the sub part of a string
       
        
        int slow=0, fast=0;
        char[] charArr = s.toCharArray(); //convert string s to access to it with indexing
        
        for(int i=0;i<s.length();i++){
          
            if(charArr[i] ==' ' || i+1 == s.length()){ //if a white space is found or the index reachs out the end of the array
              
                if(i+1 != s.length()) fast = i-1; //set fast pointer before the white space
                else fast = i;        //if there is no white space because the index reachs out the end of the array
                                      //then assign fast pointer to i 
                
                for(int j=fast;j>slow;j--){. //iterate from slow to fast 
                    char temp = charArr[slow]; //swap
                    charArr[slow++] = charArr[j];
                    charArr[j] = temp;
                }
                slow = i+1;   //set slow pointer to the next of the detected white space
            }
        }
       
        return new String(charArr);
    }
}
//O(n) because the sub reverse processing can not be same as the length of an array
