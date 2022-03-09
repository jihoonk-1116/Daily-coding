class Solution {
    public int search(int[] nums, int target) {
        int left =0, right = nums.length -1, m;
        
        while(left <= right){
            m = (left + right) / 2;
            
            if(target == nums[m]){
                return m;
            }
            
            if(nums[left] <= nums[m]){ //Look up left sorted portion.
                
                //nums[left] is the smallest value in range of left - m
                //if target is out of the bound from left - m 
                //then move left pointer to m+1 
                //otherwise, right becomes m-1 to iterate this left sorted portion
                if( target < nums[left] || target > nums[m]) left = m + 1;
                else right = m - 1;
            }
            
            else{  //Look up right sorted portion.
                
                //nums[m] is the smallest value in the range of m - right
                //if target is out of the bound from m - right 
                //then move right pointer to m-1
                //otherwise, left becomes m+1 to iterate this right sorted portion
                if(target < nums[m] || target > nums[right]) right = m - 1;
                else left = m + 1;
            }
        }
        return -1;
    }
}
