class Solution {
    public List<Integer> partitionLabels(String s) {
        //greedily select the farthest index 
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            indexMap.put(s.charAt(i), i);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        //keep maxIndex, len
        //ababcbaca  defegde  hijhklij
        int maxIndex = 0, len = 0;
        for(int i=0;i<s.length();i++){
            
            maxIndex = Math.max(indexMap.get(s.charAt(i)), maxIndex);
            
            len ++;
            
            if(maxIndex == i){
                res.add(len);
                len=0;
            }
            if(maxIndex == s.length()-1 && len > 0){
                res.add(maxIndex-i+len);
                break;
            }
            
        }
            
        return res;
    }
}
