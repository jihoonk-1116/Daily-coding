public class BottomUpDynamic{
    public int fib(int n){
      int[] table = new int[n+1]\;
      
      //Base cases
      table[0] = 0;
      table[1] = 1;
      
      for(int i=2;i<=n;i++){
        table[i] = table[i-1] + table[i-2];
      }
      
      return table[n]
    }
    public int fib(int[] memo, int n){
      if(memo[n] == 0){ //Check if the answer is already existed
        if(n-2){
          memo[n] = n;// 0 and 1
        }
        else{
            int l = fib(memo, n-1);
            int r = fib(memo, n-2);
            memo[n] = l + r;
        }
      }
      return memo[n]
    
    }
}
