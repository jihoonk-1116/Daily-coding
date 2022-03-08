class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        int max = nums[0], min = nums[0], ans = nums[0];
        
        for(int i=1;i<nums.length;i++){

            if(nums[i] < 0){ //Swap if current element is a negative integer
                int temp = max;
                max = min;
                min = temp;
            }
          
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            
            if(max > ans) ans = max;
        }
        
        return ans;
    }
}
