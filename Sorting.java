public class Sorting{
    public void bubbleSort(int[] arr){
      int n = arr.length;
      boolean isSwapped;
      
      for(int i=0;i<n-1;i++){
        isSwapped = false; //Flag to check if sorting an array is completed.
        
        for(int j=0;j<n-1;j++){
           if(arr[j] > arr[j+1]){ //If a bigger value is found than the next element in the array, do swapping  
              int temp = arr[j];
              arr[j] = arr[j+1];  
              arr[j+1] = temp; 
              isSwapped = true; //Check the flag
           }
        }
        if(isSwapped == false) break; //there is no need to iterate the loop since sorting was done-> break
      }
    }
    
    public void insertionSort(int[] arr){
        int n = arr.legnth;
        
        for(int i=1; i<n; i++){ //unsorted part of the array
          int temp = arr[i];
          int j = i-1; //sorted part of the array
          
          while(j>=0 && arr[j] >temp){ 
            arr[j+1] = arr[j];
            j--;
          }
          arr[j+1] = temp;
        }
    }
  
  public void selectionSort(int[] arr){
      int n = arr.length;
      for(int i =0;i<n-1;i++){
        int min = i;
        for(int j =i+1;j<n;j++){
            if(arr[j] < arr[min]){
                min = j;
            }
        }
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i] = temp;
      }
  }
}
