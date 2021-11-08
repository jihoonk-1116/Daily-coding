//LeetCode 9. Palindrome
//Used two pointer

class Solution { 
    public boolean isPalindrome(int x) {
        Integer i = new Integer(x); //Call Integer constructor to convert the argument x to Integer object
        String number = i.toString(); 
        //Call toString method to finally convert input parameter to String object in order to get its length and access using pointers 
        
        int s=0, e=number.length() - 1;
        
        while(s<=e){ //Do not need to check if the number is odd or not
            if(number.charAt(s) != number.charAt(e)) return false; //Not palindrome -> return false immediately
            else{
                s++; 
                e--;
            }
        }
        return true; //if the while loop is ended without stopping, the number is palindrome so return true
    }
}
