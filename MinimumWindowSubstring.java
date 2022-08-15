class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() < t.length()) return "";
        
        int matches = 0;
        int[] tHash = new int[64];
        int[] sHash = new int[64];
        
        for(int i=0;i<t.length();i++){
            tHash[t.charAt(i)-'A']++;
            sHash[s.charAt(i)-'A']++;
        }
        for(int i=0;i<64;i++) {
            if(tHash[i] > 0) matches++;
            if(sHash[i] > 0 && tHash[i] > 0 && tHash[i] <= sHash[i]) matches--;
        }
        
        if(matches == 0) return s.substring(0,t.length());
        
        int lt=0, ansLt = 0, ansRt = 0, len = s.length()+1;
        for(int rt=t.length();rt<s.length();rt++){
            
            char token = s.charAt(rt);
            sHash[token -'A']++;
            if(sHash[token-'A'] == tHash[token-'A']) matches--;
        
            while(matches == 0){
                if(len > (rt-lt+1)){
                    ansLt = lt;
                    ansRt = rt;
                    len = rt-lt+1;
                }
                token = s.charAt(lt++);
                sHash[token-'A']--;
                if(tHash[token-'A'] > 0 && sHash[token-'A'] < tHash[token-'A']) matches++;
            }
        }
        
        return len == s.length()+1 ? "" : s.substring(ansLt, ansRt+1);
    }
}
