class Solution {
   
    public boolean isPalindrome(String s){
        
        s = s.toLowerCase();
        char [] chars = s.toCharArray();
        
        int left = 0, right = s.length()-1;
        
        while(left < right){
            if(!Character.isLetterOrDigit(chars[left])) left ++;
            else if(!Character.isLetterOrDigit(chars[right])) right --;
            else if(chars[left] != chars[right]) return false;
            else{
                left ++;
                right --;
            }
        }
        
        return true;
        
    }
}

/*
   
    public boolean isPalindrome(String s){
    
        s = s.toUpperCase().replaceAll("[^A-Z0-9]","");
        
        if(s.length() == 2){
            return s.charAt(0) == s.charAt(1);
        }
        
        int left = 0, right = s.length()-1;
        
        
        while(left<right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }


public boolean isPalindrome(String s){
        
        String str = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))) str += s.charAt(i);
        }
        
        StringBuilder content = new StringBuilder(str.toLowerCase);
        
        return str.equals(content.reverse().toString());
        
    }
*/
