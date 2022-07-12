class Solution {
    public int rob(int[] nums) {
        //1st or 2nd house -> default
        //3rd house -> 3rd house + max(1st)
        //4th house -> 4th house + max(2nd)
        //choose rob or not to current house
        //even if choosing not rob, need to compare prev rob or not
        
        //memo if robbing current house, then how much money is increased.
        //prevRob, prevNotRob = 0
        //for the next case, prevRob = curRob, prevNotRob = Math.max(prevRob, )
        // 2  1  1  2
        if(nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]); 
        }
        
        return dp[nums.length-1];
    }
}
