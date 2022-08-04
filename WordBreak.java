class Solution {
    public boolean wordBreak(String s, List<String> wordList) {
        
        Set<String> dict = new HashSet<>();
        for(String word : wordList) dict.add(word);
    
        if(s.length()==1) return dict.contains(s);
            
        int[] checker = new int[s.length()];
        checker[0] = 1;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                String sub = s.substring(j,i);
                if(dict.contains(sub) && (j == 0 || checker[j-1] == 1)) {
                    checker[i] = 1;
                    break;
                }
            }
        }
        
        return checker[s.length()-1] == 1 ? true : false;
        
    
        
//         boolean[] dp = new boolean[s.length() + 1];
        
//         Set<String> set = new HashSet<>();
//         for (String word : wordList) {
//             set.add(word);
//         }
        
//         dp[0] = true;
        
//         for (int i = 1; i <= s.length(); i++) { //cuz we utilze substring, i should iterate by s.length()
//             for (int j = 0; j < i; j++) {
//                 String sub = s.substring(j,i);
//                 if(dp[j] && set.contains(sub)) { //j is always stopped before i 
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }
        
        
//         return dp[s.length()];
    
    }
}


/*
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // DFS
        Set<Integer> set = new HashSet<Integer>();
        return dfs(s, 0, dict, set);
    }
    
    private boolean dfs(String s, int index, Set<String> dict, Set<Integer> set){
        // base case
        if(index == s.length()) return true;
        // check memory
        if(set.contains(index)) return false;
        // recursion
        for(int i = index+1;i <= s.length();i++){
            String t = s.substring(index, i);
            if(dict.contains(t))
                if(dfs(s, i, dict, set))
                    return true;
                else
                    set.add(i);
        }
        set.add(index);
        return false;
    }
}
*/
