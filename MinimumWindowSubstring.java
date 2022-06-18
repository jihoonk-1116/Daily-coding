class Solution {

    public String minWindow(String s, String t) {
        //find minimun window that includes t
        //hash map comparing? 
        
       
        
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        
        for(char c : t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        
        int have = 0, need = mapT.size();
        int minLen = Integer.MAX_VALUE;
        int lt = 0, resLt = 0;
        
        for(int rt=0;rt<s.length();rt++){
            
            char c = s.charAt(rt);
            mapS.put(c, mapS.getOrDefault(c,0) + 1);
            
            if(mapT.containsKey(c) && mapT.get(c) == mapS.get(c)){
                have++;
            }
            //aaabbbbccdd
            while(have == need){ //all characters in t is found 
                //update result
                if((rt - lt + 1) < minLen){
                    resLt = lt;
                    minLen = rt - lt + 1;
                }
                //pop left
                //update window map
                mapS.put(s.charAt(lt), mapS.get(s.charAt(lt)) - 1);
                if(mapT.containsKey(s.charAt(lt)) &&
                   mapT.get(s.charAt(lt)) > mapS.get(s.charAt(lt))){
                       have --;
                }
                lt++;
            }
            
        }
                   
        if(minLen > s.length()) return "";
        else return s.substring(resLt, resLt+minLen);
    }
}
