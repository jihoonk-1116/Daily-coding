class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length-2), robHelper(nums, 1, nums.length-1));
    }
    private int robHelper(int[] nums, int s, int e){
        
        int prevRob = 0, notPrevRob = 0;
        
        for(int i=s;i<=e;i++){
            int curRob = nums[i] + notPrevRob;
            int curNotRob = Math.max(prevRob, notPrevRob);
            
            prevRob = curRob;
            notPrevRob = curNotRob;
        }
        
        return Math.max(prevRob, notPrevRob);
    }
}
