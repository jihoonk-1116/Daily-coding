/*
dp[n] is "how many ways are there to decode the given string, up to and including the nth character"
dp[0] then is "how many ways are there to decode a string of 0 length"
There is only one: you must interpret it as an empty string.
It is a base case. I wish the explanation would have said that explicitly.
Actually dp[0] = 1 is a special case in recursion.. We when check corner case, we should return according to the problem statement. We return 0 cause the problem statement, we make dp[0] = 1 cause we have to make sure dp[2] is valid.
*/
class Solution{
    public int numDecodings(String s) {

        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2;i<dp.legnth;i++){
            if(s.charAt(i-1) != '0') dp[i] += dp[i-1];
            if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) < '7'){
                dp[i] += dp[i-2];
            }
        }
        
        return dp[s.length()];
    }
}

// class Solution {
//     public int numDecodings(String s){
        
//         int[] dp = new int[s.length()+1];
//         dp[0] = 1; // empty string 
//         dp[1] = s.charAt(0) == '0' ? 0: 1;
        
//         for(int i=2; i < s.length()+1; i++){
            
//             if(s.charAt(i-1) != '0') dp[i] += dp[i-1];
            
//             if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7')){
//                 dp[i] += dp[i-2];
//             }
//         }
//         return dp[s.length()];
//     }
// }

//     public int numDecodings(String s) {
//         return s.length()==0?0:numDecodings(0,s);      
//     }

//     private int numDecodings(int p, String s) {
//         int n=s.length();
//         if(p==n) return 1;
//         if(s.charAt(p)=='0') return 0                                                                                                                 ;
//         int res=numDecodings(p+1,s);
//         if(p<n-1&&(s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7')) 
// 			res+=numDecodings(p+2,s);
//         return res;
//     }

//     public int numDecodings(String s) {
//         return s.length() == 0 ? 0 : numDecodings(0, s, new int[s.length()]);      
//     }
//     private int numDecodings(int index, String s, int[] mem) {

//         if(index >= s.length()) return 1;
//         if(s.charAt(index)=='0') return 0;
//         if(mem[index] != null) return mem[index];

//         int res=numDecodings(index+1,s,mem);
        
//         if(index<s.length()-1&&(s.charAt(index)=='1'|| s.charAt(index)=='2'&& s.charAt(index+1)<'7')) 
// 			    res+=numDecodings(index+2,s,mem);
        
//         return mem[index]=res;
//     }
