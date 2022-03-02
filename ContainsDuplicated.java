//Time: O(n) , Space: O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.add(nums[i])) continue;
            return true;
        }
        return false;
    }
}
