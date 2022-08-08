class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int lt = i+1, rt = nums.length-1;
            while(lt < rt){
                int sum = nums[i] + nums[lt] + nums[rt];
                if(sum < target) {
                    res += rt-lt;
                    lt++;
                }
                else rt--;
            }
        }
        return res;
    }
}
