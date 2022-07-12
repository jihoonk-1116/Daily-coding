class Solution {
    
    int res = 0;
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;
        
        for(int i=0;i<s.length();i++){
            //even palindrome
            palinSubString(i,i,s);
            //odd palindrome
            palinSubString(i,i+1,s);
        }
        return res;
    }
    
    private void palinSubString(int l, int r, String s){
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) != s.charAt(r)) return;
            res ++;
            l --;
            r ++;
        }
    }
}
