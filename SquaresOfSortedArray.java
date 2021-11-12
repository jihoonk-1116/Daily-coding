/*
Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.
Solve it in O(n)
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
       //brute force
       //1. first iterate -> squares each element
       //2. sort
        //Any most fastest sorting alg can not satisfy linear time O(n)
        
        //Use two pointers that point at the first of the array and at the last of the array
        //compare s*s with e*e or use absolute number
        //put bigger one into result array, then move one of the pointers
        
        int s = 0, e = nums.length-1;
        int[] result = new int[e+1];
        int resultIndex = e;
        
        while(resultIndex>=0){
          
            if(nums[s]*nums[s]<=nums[e]*nums[e]){
                result[resultIndex--] = nums[e]*nums[e];
                e--;
            }
            else{
                result[resultIndex--] = nums[s]*nums[s];
                s++;
            }
        }
        return result;
    }
}
