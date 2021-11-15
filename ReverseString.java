/*
https://leetcode.com/problems/reverse-string/

Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
*/

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        for(int i=0;i<s.length;i++){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
            if(left >= right) break;
        }
    }
}
