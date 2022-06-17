class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //find permutation first
        //use two hash
        //check if they are equal -> true 
        
        if (s1.length() > s2.length()) return false;
        
        int[] charHash1 = new int[26];
        int[] charHash2 = new int[26];
        
        //iterate thru s2 
        //use window to find permutation substring in s2 with size of s1
        int lt = 0;
        for(int rt=0;rt<s2.length();rt++){
            if(rt < s1.length()){ //fill up the hash maps by s1.len
                charHash1[s1.charAt(rt) -'a']++;
                charHash2[s2.charAt(rt) -'a']++;
            }
            else if(matches(charHash1, charHash2)) return true;
            else{ //move window 
                System.out.println(rt);
                charHash2[s2.charAt(rt) - 'a']++;
                charHash2[s2.charAt(lt) - 'a']--;
                lt++;
            }
            
        }
        return matches(charHash1, charHash2);
    }
    private boolean matches(int[] map1, int[] map2){
        for(int i= 0;i<26;i++){
            if(map1[i] != map2[i]) return false;
        }
        return true;
    }
}
               
