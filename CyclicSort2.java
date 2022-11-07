class CyclicSort2{
  private static int findDuplicate(int[] arr){
        int ind = 0;
        while(ind < arr.length){
            if(arr[ind] != ind+1){
                //while swaping, if there already is an element in the proper position
                //then the element at the index is duplicate.
                if(arr[ind] != arr[arr[ind]-1]){
                    int temp = arr[ind];
                    arr[ind] = arr[temp-1];
                    arr[temp-1] = temp;
                }
                else return arr[ind];
            }
            else ind++;
        }
        return -1;
    }

  private static List<Integer> findAllDuplicate(int[] arr){
        int ind = 0;
        while(ind < arr.length){
            if(arr[ind] != arr[arr[ind]-1]){
                int temp = arr[ind];
                arr[ind] = arr[temp-1];
                arr[temp-1] = temp;
            }
            else ind++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] != i+1) res.add(arr[i]);
        }

        return res;
    }

}
  
