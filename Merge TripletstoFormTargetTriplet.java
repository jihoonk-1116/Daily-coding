class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        /*
        Consider only triplets that do not exceed the target in any dimension.
        Greedily apply the operation using all those triplets. 
        That way, res will get as close to a target as possible.
        
        */
        Set<Integer> set = new HashSet<>();
        
        for(int [] triplet : triplets) {
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]){
                continue;
            }
            
            for(int i=0;i<3;i++){
                if(target[i] == triplet[i]) set.add(i);
            }
        }
        
        return set.size() == 3;
    }
}
/*
https://leetcode.com/problems/merge-triplets-to-form-target-triplet/discuss/1268574/Java-One-Pass-Clean-and-Easy

        Consider only triplets that do not exceed the target in any dimension.
        Greedily apply the operation using all those triplets. 
        That way, res will get as close to a target as possible.
        
        
public boolean mergeTriplets(int[][] triplets, int[] t) {
    int[] res = new int[3];
    for (var s : triplets)
        if (s[0] <= t[0] && s[1] <= t[1] && s[2] <= t[2])
            res = new int[]{ Math.max(res[0], s[0]), Math.max(res[1], s[1]), Math.max(res[2], s[2]) };
    return Arrays.equals(res, t);
}

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int res[] = new int[]{0, 0, 0};
        for(int[] triplet : triplets) {
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                res[0] = Math.max(triplet[0], res[0]);
                res[1] = Math.max(triplet[1], res[1]);
                res[2] = Math.max(triplet[2], res[2]);
            }
        }
        return Arrays.equals(target, res);
    }
}

*/
