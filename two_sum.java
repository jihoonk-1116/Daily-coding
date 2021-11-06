class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] answer = new int[2];
        
        //First, all of the array's element is put to a map
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        //Find target with containsKey using : target = nums[i] + nums[j] -> target-nums[i] = nums[j]
        for(int i=0;i<nums.length;i++){
            int find = target - nums[i];
            
            if(map.containsKey(find) && map.get(find) != i){ //Prevent using same index value twice
                answer[0] = i;
                answer[1] = map.get(find); //find will be a key
            }
        }
        return answer;
    }
}
