class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        //Set<Character> charSet = new HashSet<>();
        int [] charSet = new int[128];
        int max = 0, lt = 0;
        
        for(int rt=0;rt<s.length();rt++){
         
            char c = s.charAt(rt);
            
            //---using ascii code ---
            while(lt<rt && charSet[c] == 1) charSet[s.charAt(lt++)] = 0;
            charSet[c] = 1;
            max = Math.max(max, rt - lt + 1);
            
            //---- using set ----
            //while(lt < rt && charSet.contains(c)) charSet.remove(s.charAt(lt++));
            //charSet.add(c);
            //max = Math.max(max, rt - lt+1);
        }
        return max;
    }
}
