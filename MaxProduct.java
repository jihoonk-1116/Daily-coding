class Solution {
    public int maxProduct(int[] nums) {
        //dp 
        //2 3  -2   4    
        //2 6 -12 -48 48
        //  3  -6  -24
        //     -2  -8
        //-2 0 -1
        //-2 0 0
        if(nums.length == 1) return nums[0];
        
        int curMin = 1, curMax = 1, res=Integer.MIN_VALUE;
        //cases
        //1. positive consecutive
        //2. becoming negative
        //3. 0
        for(int n : nums){
            
            int tmpMax = curMax;
            
            curMax = Math.max(curMax * n, curMin*n); //if n is pos-> curMax becomes max. ow, curMin
            curMax = Math.max(curMax, n);
            
            curMin = Math.min(tmpMax * n, curMin*n); //if n is pos-> curMax becomes max. ow, curMin
            curMin = Math.min(curMin, n);
            
            res = Math.max(res, curMax);
        }
        
        return res;
    }
}
