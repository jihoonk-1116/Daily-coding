//Leetcode 13. Roman to Integer
//My answer using two pointers and two hash
// -> too slow : 37ms , too much high space complexity 

class Solution {
    public int romanToInt(String s) {
        HashMap<String,Integer> subroman = new HashMap<String, Integer>();
        HashMap<Character,Integer> roman = new HashMap<Character, Integer>();
        
        subroman.put("IV", 4);
        subroman.put("IX", 9);
        subroman.put("XL", 40);
        subroman.put("XC", 90);
        subroman.put("CD", 400);
        subroman.put("CM", 900);
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        
        int slow=0, fast=2, length = s.length()-1, sum=0;
        
        
        while(slow<=length){
            if(fast <= length +1 && subroman.containsKey(s.substring(slow,fast))){ //not subroman
                sum += subroman.get(s.substring(slow,fast));
                slow+=2; fast+=2;
            }
            else{
                sum += roman.get(s.charAt(slow));
                slow++; fast++;
            }
            //System.out.println(slow + " " + fast);
            
        }
        return sum;
    }
}


//Optimized version
//Source by HelloWorld123456 , Link: https://leetcode.com/problems/roman-to-integer/discuss/6520/JAVA-Easy-Version-To-Understand!!!!
public static int romanToInt(String s) {
	if (s == null || s.length() == 0) return -1;
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	map.put('I', 1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D', 500);
	map.put('M', 1000);
	int len = s.length(), result = map.get(s.charAt(len - 1)); //Begin at the last of the element
	for (int i = len - 2; i >= 0; i--) {                    //iterate the string in reverse order
		if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) //if the element on the current index is bigger than the next one
			result += map.get(s.charAt(i));                     //add the value to result
		else                                                  //if not, it will be subtraction roman
			result -= map.get(s.charAt(i));                     //so, minus result as the value
	}
	return result;
}
