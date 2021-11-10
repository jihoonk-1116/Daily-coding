//From https://www.youtube.com/watch?v=f35VqXSsP6Y&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=171

public class MaxSubArraySum{
    public static int maxArraySum(int[] arr){
        int currentMax = arr[0];
        int maxSoFar = arr[0];
        for(int i =1;i<arr.length;i++){
            currentMax = currentMax + arr[i]; //memorization
            if(currentMax < arr[i]){
                currentMax = arr[i];
            }
            if(maxSoFar < currentMax){
                maxSoFar = currentMax;
            }
        }
      return maxSoFar
        
    }
  public static void main(String[] args){
    int[] arr = {4,3,-2,6,-12,7,-1,6};
    System.out.println(maxArraySum(arr));
  }
}
