class Solution {
  //without dynamic programming -> O(2^n)
    // public int fib(int n) {
    //     if(n==0) return 0;
    //     else if(n==1) return 1;
    //     else return fib(n-1)+fib(n-2);
    // }
  
  //with dynamic programming
  //O(n)
    public int fib(int n){
        int[] result = new int[n+1];
        for(int i = 0;i<=n;i++){
            if(i==0) result[i] = 0;
            else if(i==1) result[i] = 1;
            else result[i] = result[i-1] + result[i-2]; 
        }
        return result[n];
    } 
}
