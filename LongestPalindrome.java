class Solution {
    public String longestPalindrome(String s) {
        //expand left and right
        if(s.length() == 1) return s;
        int maxLen = 0, curLen;
        String res = "";
        for(int i = 0;i<s.length();i++){
            int left = i;
            int right = i;
            
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    curLen = right - left + 1;
                    maxLen = Math.max(maxLen, curLen);
                    if(res.length() < maxLen) res = s.substring(left,right+1);
                }
                else break;
                
                left --;
                right ++;
            }
            left = i;
            right = i + 1;
            while(left >= 0 && right<s.length()){
                if(s.charAt(left) == s.charAt(right)){ 
                    curLen = right - left + 1;
                    maxLen = Math.max(maxLen, curLen);
                    if(res.length() < maxLen) res = s.substring(left,right+1);
                }
                else break;
                
                left --;
                right ++;
            }
        }
        
        return res;
    }
}
/*
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

*/
