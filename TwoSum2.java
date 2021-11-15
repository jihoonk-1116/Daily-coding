//sorted array
//find two sum indices

class Solution {
  //HashMap approach
 
    public int[] twoSum(int[] numbers, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
      
        for(int i=0;i<numbers.length;i++){ //put all the element of an array into hash map
            map.put(numbers[i], i);     //key is the elements of the array, and value is their index
        }
      
        for(int i=0;i<numbers.length;i++){  //iterate to find target
            if(map.containsKey(target - numbers[i])){ //key target = numbers[i_1] + numbers[i_2] -> numbers[i_1] = target - numbers[i_2]
                result[0]=i+1;
                result[1]=map.get(target - numbers[i])+1;
                break;
            }
        }
        return result;
    }
  
  //Two pointers approach
  //From https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/discuss/51239/Share-my-java-AC-solution. by xhadfasd


   public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1; //find target using two pointers
        while(start < end){
            if(numbers[start] + numbers[end] == target) break; //when we find the indice
            if(numbers[start] + numbers[end] < target) left++; //increase left because the array is sorted by acsending order
            else right--; //decrease right because the array is sorted by acsending order
        }
        return new int[]{start + 1, end + 1};
    }
}
