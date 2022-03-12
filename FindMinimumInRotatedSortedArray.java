class Solution {
    /*
    Find pivot that is smaller than its left
    then the pivot becomes the minimum value. 
    */
    public int findMin(int[] nums) {
        int ans = nums[0], left = 0, right = nums.length - 1, m;
        
        while(left <= right){
            
            if(nums[left] < nums[right]) {
                ans = Math.min(nums[left], ans);
                break;
            }
            
            m = (left + right) / 2;
            ans = Math.min(nums[m], ans);
            
            if(nums[left] <= nums[m]) left = m + 1;
            else right = m - 1;
            
        }
        return ans;
        
        
    }
}
