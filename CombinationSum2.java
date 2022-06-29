class CombinationSum2 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        sumHelper(candidates, target, new ArrayList<Integer>(), 0);
        
        return res;
    }
    
    private void sumHelper(int[] candidates, int target, ArrayList<Integer> combi, int choice){
        if(target == 0){
            res.add(new ArrayList(combi));
            return;
        }
        if(target < 0) return;
        
        for(int i=choice;i<candidates.length;i++){
            if(i>choice && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) continue;
            
            combi.add(0,candidates[i]);
            sumHelper(candidates, target - candidates[i], combi, i + 1);
            combi.remove(0);
        }
    }
//     private void sumHelper(int[] candidates, int target, int curSum, ArrayList<Integer> combi, int depth){
        
//         if(curSum == target){
//             res.add(new ArrayList<>(combi));
//             return;
//         }
        
//         if(depth >= candidates.length || curSum > target) return;

//         else{
//             for(int i = depth;i<candidates.length;i++){
                
//                 if( i > depth && candidates[i] == candidates[i-1]) continue;
//                 if(target < candidates[i]) continue;
                
//                 combi.add(0, candidates[i]);
//                 sumHelper(candidates, target, curSum + candidates[i], combi, i + 1);
//                 combi.remove(0);
//             }
            
//         }
//     }
}
