class Solution{ //198. House Robber
//
    public int rob(int[] nums){
        int[] memo = new int[nums.length];
        if (nums.length < 2) return nums[0]; //
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(nums[i] + memo[i-2], memo[i-1]);
        }
        return memo[memo.length - 1];
    }

    // private int getMax(int i, int[] nums) {
    //     if (i > 1) {
    //         return Math.max(nums[i] + nums[i-2], nums[i-1]);
    //     }
    //     return 
    // }
}

// [1, 2, 3, 1]
// [1, 3]
// [1, 1]
// [2, 1]
// [3]


// [1]

// [1,2]
// [1]
// [2]

// [1,2,3]
// [1,3]
// [2]

// [1, 2, 3, 1]
// [1, 2, 4, 4]

// [2, 7, 9, 3, 1]
// [2, 7, 11, 11, 12]


// [2, 0, 0, 9, 1, 0, 10] = 21
// [2, 2, 2, 11, 11, 11, 21]

class Solution {
    
    private int[] memo = new int[100];
    public int rob (int[] nums) {
        return robTopDownHelper(nums.length - 1, nums);
    }

    public int robTopDownHelper(int index, int[] nums) {
        if (index == 0) {
            return nums[index];
        } 

        if (index == 1) {
            return Math.max(nums[0], nums[1]);
        }

        if (memo[index] > 0)
            return memo[index];

        memo[index] = Math.max(robTopDownHelper(index - 1, nums), robTopDownHelper(index - 2, nums) + nums[index]);
        return memo[index];
    }
}


class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int[] nums;
    
    private int dp(int i) {
        // Base cases
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]);
        if (!memo.containsKey(i)) {
            memo.put(i, Math.max(dp(i - 1), dp(i - 2) + nums[i])); // Recurrence relation
        }
        return memo.get(i);
    }
    
    public int rob(int[] nums) {
        this.nums = nums;
        return dp(nums.length - 1);
    }
}
