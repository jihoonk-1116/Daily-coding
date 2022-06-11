public class FindAllAnagram {
    public static void main(String[] args) {
        //bacaAacba
        //abc
        //bac, acb, cba
        //anagram -> hash
        //use fixed size window
        String word = "bacaAacbaa";
        String pattern = "aa";
        System.out.println(findAnagram(word, pattern));
    }
    
    static private int findAnagram(String word, String pattern){
        
        int numOfAna = 0;
        //use two hashmap
        HashMap<Character, Integer> wordMap = new HashMap<>();
        HashMap<Character, Integer> patternMap = new HashMap<>();
        
        //fill up a map with pattern 
        for(char c : pattern.toCharArray()){
            patternMap.put(c,patternMap.getOrDefault(c, 0) + 1);
        }
        //for loop
        int l =0;
        for(int r=0;r<word.length();r++){
             //pre-fill up another map with word as len(word) - 1
            if(r < pattern.length()-1){
                wordMap.put(word.charAt(r), 
                            wordMap.getOrDefault(word.charAt(r), 0) + 1);
            }
            else{
                //add one more character to the map for word
                wordMap.put(word.charAt(r), 
                            wordMap.getOrDefault(word.charAt(r), 0) + 1);
                
                //compare two maps -> if same, then count++
                //otherwise, do nothing and go to next
                if(wordMap.equals(patternMap)) numOfAna++;
                
                //before the next, take out one character from word map
                wordMap.put(word.charAt(l), wordMap.get(word.charAt(l)) - 1);
                if(wordMap.get(word.charAt(l)) == 0)
                    wordMap.remove(word.charAt(l));
                
                l++;
                
            }
        }
        
        return numOfAna;
    
    }
}
//leetcode
class Solution {
    public List<Integer> findAnagrams(String word, String pattern) {
        
        ArrayList<Integer> indicesOfAna = new ArrayList<>();
        
        //use two hashmap
        HashMap<Character, Integer> wordMap = new HashMap<>();
        HashMap<Character, Integer> patternMap = new HashMap<>();
        
        //fill up a map with pattern 
        for(char c : pattern.toCharArray()){
            patternMap.put(c,patternMap.getOrDefault(c, 0) + 1);
        }
        //for loop
        int l =0;
        for(int r=0;r<word.length();r++){
             //pre-fill up another map with word as len(word) - 1
            if(r < pattern.length()-1){
                wordMap.put(word.charAt(r), 
                            wordMap.getOrDefault(word.charAt(r), 0) + 1);
            }
            else{
                //add one more character to the map for word
                wordMap.put(word.charAt(r), 
                            wordMap.getOrDefault(word.charAt(r), 0) + 1);
                
                //compare two maps -> if same, then count++
                //otherwise, do nothing and go to next
                if(wordMap.equals(patternMap)) indicesOfAna.add(l);
                
                //before the next, take out one character from word map
                wordMap.put(word.charAt(l), wordMap.get(word.charAt(l)) - 1);
                if(wordMap.get(word.charAt(l)) == 0)
                    wordMap.remove(word.charAt(l));
                
                l++;
                
            }
        }
        
        return indicesOfAna;
    }
}
