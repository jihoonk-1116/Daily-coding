class Solution {
    
    //int[] dp;
    public int climbStairs(int n) {
        
        if(n<=1) return n;
        
        // dp = new int[n+1];
        // dp[1] = 1;
        // dp[2] = 2;
        
        return bottomUpOP(n);
    }
    
//     private int topDown(int n){
//         if(n==0) return 0;
//         if(dp[n] != 0) return dp[n];
//         return dp[n] = topDown(n-1) + topDown(n-2);
//     }
    
//     private int bottomUp(int n){
//         for(int i=3;i<=n;i++){
//             dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
    
    private int bottomUpOP(int n){
        
        int s1 = 1;
        int s2 = 2;
        
        for(int i=3;i<=n;i++){
            int t = s2;
            s2 = s1+s2;
            s1 = t;
        }
        return s2;
    }
    
}
