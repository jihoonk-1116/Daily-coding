//Leetcode 704 - requirement : O(logn)
//Brute force approach

class Solution {
    public int search(int[] nums, int target) {
        
        int s=0, m = nums.length/2 - 1; //using pre-fixed pivot
        
        if(m<2){ //if the nums array is less than length 4
            for(int i = s; i<nums.length;i++){
                 if(nums[i] == target) return i;
             }
        }
        else if(nums[m] == target) return m;
        
        else if(nums[m] < target) { //if target is greater than the middle element of the nums
                                    //iterate the half of the right side of the array because the array was sorted
             s = m;
             m = nums.length;
            
             for(int i = s; i<m;i++){
                 if(nums[i] == target) return i; //if success to find, return index
             }
        }
        else{
            //if target is less than the middle element of the nums
            //iterate the half of the left side of the array because the array was sorted
             for(int i = s; i<m;i++){
                 if(nums[i] == target) return i; //if success to find, return index
             }
        }    
        return -1; //Not found
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
