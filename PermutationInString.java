class Solution {
    
//     public boolean checkInclusion(String s1, String s2) {
        
//         if (s1.length() > s2.length()) return false;
        
//         int[] charHash1 = new int[26];
//         int[] charHash2 = new int[26];
        
//         for(int i=0;i<s1.length();i++){
//             charHash1[s1.charAt(i) - 'a'] ++;
//             charHash2[s2.charAt(i) - 'a'] ++;
//         }
     
//         int lt = 0;
//         for(int rt=s1.length();rt<s2.length();rt++){
//             if(matches(charHash1, charHash2)) return true;
//             else{ //move window 
//                 charHash2[s2.charAt(rt) - 'a']++;
//                 charHash2[s2.charAt(lt) - 'a']--;
//                 lt++;
//             }
            
//         }
//         return matches(charHash1, charHash2);
//     }
//     private boolean matches(int[] map1, int[] map2){
//         for(int i= 0;i<26;i++){
//             if(map1[i] != map2[i]) return false;
//         }
//         return true;
//     }
         
    
    
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()> s2.length()) return false;
        
        int[] charMap = new int[26];
        for(int i=0;i<s1.length();i++){
            charMap[s1.charAt(i)-'a']++;
            charMap[s2.charAt(i)-'a']--;
        }
        
        int matches = 0;
        for(int i=0;i<26;i++){
            if(charMap[i] == 0) matches ++;
        }
        
        int lt = 0;
        for(int rt=s1.length();rt<s2.length();rt++){
            
            if(matches == 26) return true;
            
            int curLetterKey = s2.charAt(rt) - 'a';
            charMap[curLetterKey]--;
            if(charMap[curLetterKey] == 0) matches++;
            else if(charMap[curLetterKey] == -1) matches --;
            
            int leftLetterKey = s2.charAt(lt++) - 'a';
            charMap[leftLetterKey] ++;
            if(charMap[leftLetterKey] == 0) matches ++;
            else if(charMap[leftLetterKey] == 1) matches --; 
            
        }
        
        return matches == 26;
    }
}
