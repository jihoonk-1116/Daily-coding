/*
Leetcode 35.Search Insert Position

Given a sorted array of distinct integers and a target value,
return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1; //assign indexes
        
        while(left<right){ //Do binary search
            int mid = left + (right-left)/2; //to prevent right + left >= 1<<32 -> overflow in Java
            if(nums[mid]==target) return mid; 
            if(nums[mid] > target) right = mid;
            else left = mid+1;
        }
        if(nums[left] != target) { //Handle if there was no target value
            if(nums[left] < target) return left+1; //the result value is less than target,
                                                   //then the target should be located to the next.
        }
        return left; //case: found target or not found, but the result value is greater than target
                                                      //  -> then, the target value should be placed at the current left
    }
}
