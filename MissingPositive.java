class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hashset = new HashSet<Integer>();
        int smallest = 1; //The smallest positive integet is 1, not 0.
        
        for(int i=0;i<nums.length;i++){ //Put all element to hashset
            hashset.add(nums[i]);       
        }
        for(int i=0;i<nums.length;i++){ 
            if(hashset.contains(smallest)) smallest++; //If collision occurs, increase smallest
            else break; //if not, break -> found first missing integer
        }
        return smallest;
    }
}
//O(n) time
