//memoization
class Solution {
    int [] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        memo[0] = cost[0];
        memo[1] = cost[1];
        helper(cost, cost.length-1);
        return Math.min(memo[cost.length-1], memo[cost.length-2]);
        
    }
    private int helper(int[] cost, int index){
        if(index < 0) return 0;
        if(memo[index] != 0) return memo[index];
        return memo[index] = cost[index] + Math.min(helper(cost,index-1), helper(cost, index-2));
    }
}

//tabulation
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int res = 0;
        int[] table = new int[cost.length];
        table[0] = cost[0];
        table[1] = cost[1];
        for(int i=2;i<cost.length;i++){
            table[i] = Math.min(table[i-2], table[i-1]) + cost[i];
        }
        return Math.min(table[cost.length-1], table[cost.length-2]);
    }
}
