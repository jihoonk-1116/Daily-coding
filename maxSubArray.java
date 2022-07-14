class Solution {
    public int maxSubArray(int[] nums) {
        //find max sub array sum
        //sliding window 
        //move lt when the cursum becomes negative.
        //keep max 
        // greedy-like intuition
        // any subarray whose sum is positive is worth keeping.
        //Whenever the sum of the array is negative, we know the entire array is not worth keeping
        
        /*
        Kadane's Algorithm
        
        def max_subarray(numbers):
        """Find the largest sum of any contiguous subarray."""
        best_sum = 0
        current_sum = 0
        for x in numbers:
            current_sum = max(0, current_sum + x)
            best_sum = max(best_sum, current_sum)
        return best_sum
        */
        int res = Integer.MIN_VALUE;
        int curSum = 0;
        //-2 1 -3 4 -1 2 1 -5 4
        //-2 1 -2 4 
        for(int n : nums){
            
            if(curSum < 0) curSum = 0; //whenever curSum becomes negative, assign curSum = 0
            // if(curSum < 0 && curSum < n){
            //     curSum = n;
            // }    
            // else 
            //     curSum += n;
            curSum += n;
            res = Math.max(res, curSum);
            
        }
        
        return res;
    }
}
