/*
189. Rotate Array
*/

class Solution {
    public void rotate(int[] nums, int k) {
        
        //Approach
        //[1,2,3,4,5]
        //[5,1,2,3,4]
        //1. temp = nums[last]
        //2. iterate from last to 1 to copy , use fast pointer and slow pointer
        //3. decrase index , if index == 0 -> temp data
        //do 1~3 steps k % length times to reduce rebundant loop
       
        
        int length = nums.length, start = 0 ,end = length -1;
        k = k % length;
        
        while(k>0){
            
            int temp = nums[end];
            
            for(int i=end;i>0;i--){
                   nums[i] = nums[i-1];
            }
            
            nums[0] = temp;
            k--;
        }
       
    }
}
//O(n*k)
