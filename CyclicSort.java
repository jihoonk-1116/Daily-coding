public class CyclicSort{
  public static void main(String[] args){
       int[] arr = new int[]{3,1,5,4,2};
       cyclicSort(arr);
       Arrays.stream(arr).forEach((n)->{
           System.out.print(n + " ");
       });
  
  }
  
  public void cyclicSort(int[] nums){
      int ind = 0;
      while(ind < arr.length){
        if(nums[ind] != nums[nums[ind]-1]){
            int temp = nums[i];
            nums[i] = nums[temp-1];
            nums[temp-1] = temp;     
        }
        else ind++;
      }
  }
}
