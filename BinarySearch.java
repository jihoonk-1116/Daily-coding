//Leetcode 704 - requirement : O(logn)
//Brute force approach

class Solution {
    public int search(int[] nums, int target) {
        
        int s=0, m = nums.length/2 - 1;
        
        if(m<2){
            for(int i = s; i<nums.length;i++){
                 if(nums[i] == target) return i;
             }
        }
        else if(nums[m] == target) return m;
        
        else if(nums[m] < target) {
            
             s = m;
             m = nums.length;
            
             for(int i = s; i<m;i++){
                 if(nums[i] == target) return i;
             }
        }
        else{
            
             for(int i = s; i<m;i++){
                 if(nums[i] == target) return i;
             }
        }    
        return -1;
    }
}

//Optimized solution by qqqzhouhk : https://leetcode.com/problems/binary-search/discuss/151320/concise-Java-solution-beats-100

    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
