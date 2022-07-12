class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        
        for(int i=0;i<cost.length;i++){
            if(i<2){
                dp[i] = cost[i];
            }
            else{
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            }
        }
        
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
    
    private int helper(int[] cost, int n){
        if(n < 0) return 0;
        if(n == 0 || n == 1) return cost[n];
        if(dp[n] != 0) return dp[n];
        
        return dp[n] = cost[n] + Math.min(helper(cost, n-1), helper(cost, n-2));
      
    }
}
