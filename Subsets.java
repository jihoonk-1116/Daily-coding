class Solution {
    
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        subsetHelper(nums, 0, new ArrayList<Integer>());
        return res;
    }
    
    public void subsetHelper(int[] nums, int d, ArrayList<Integer> subSet){
        if(d == nums.length){
            res.add(new ArrayList(subSet));
        }
        else{
            subSet.add(nums[d++]);
            subsetHelper(nums, d, subSet);
            subSet.remove(subSet.size()-1);
            subsetHelper(nums, d, subSet);
        }
    }
}
//O(N * 2^N)
// class Solution {
    
//     List<List<Integer>> res;
//     public List<List<Integer>> subsets(int[] nums) {
//         res = new ArrayList<List<Integer>>();
//         subsetHelper(nums, new int[nums.length], 0);
//         return res;
//     }
    
//     public void subsetHelper(int[] nums, int[] check, int depth){
//         if(depth == nums.length){
//             ArrayList<Integer> subset = new ArrayList<>();
//             for(int i=0;i<check.length;i++){
//                 if(check[i] == 1){
//                     subset.add(nums[i]);
//                 }
//             }
//             res.add(subset);
//         }
//         else{
//             check[depth] = 0;
//             subsetHelper(nums, check, depth + 1);
//             check[depth] = 1;
//             subsetHelper(nums, check, depth + 1);
//         }
//     }
// }
