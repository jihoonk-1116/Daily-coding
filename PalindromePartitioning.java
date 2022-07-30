//N*2^N

class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<List<String>>();
        helper(s, new ArrayList<String>(), 0);
        return res;
    }
    
    private void helper(String s, ArrayList<String> subSet, int start){
        if(s.length() <= start){
            res.add(new ArrayList(subSet));
        }
        else{
            for(int i=start;i<s.length();i++){
                
                String sub = s.substring(start, i+1);
                if(!isPalin(sub)) continue;
                
                subSet.add(sub);
                helper(s, subSet, i+1);
                subSet.remove(subSet.size()-1);
            }
        }
    }
    private boolean isPalin(String s){
        int l = 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
