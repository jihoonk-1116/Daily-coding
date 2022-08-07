//Instead of using the classic recursive approach i.e. x*pow(x, n-1) just have (x*x), i.e., pow(x*x, n/2). 
//This will make the TC logarithmic instead of linear.
//Just take care of the edge cases like Integer.MIN_VALUE, negative power, odd cases.
//Asked in Amazon, Meta, Google, Linkedin, Bloomberg
class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        
        //double res = helper(x,Math.abs(n),1);
        
        //return n > 0 ? res : 1/res;
        
        return whileHelper(x,n);
        
    }
    
    private double helper(double x, int n, double res){
        
        if(n==0) return 1;
        
        res = helper(x, n/2, res);
        res = res * res;
        
        return n % 2 == 0 ? res : res*x;
    }
    
    private double iterHelper(double x, int n){
    
        long N = n;
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double res = 1;
        
        for(long i=N;i>0;i/=2){
            if(i%2 == 1){
                res = res * x;
            }
            x *= x;
        }
        return res;
    }
    
    public double whileHelper(double x, int n) {
        
        long N = n;
        double res=1;
        
        if(n < 0) {
            x = 1/x;
            N = -N;
        }
        
        while(N!=0){
            
            if(N%2==0){ //even case
                x=x*x;
                N/=2;
            }
            else{  //odd casA
                res *= x;
                N--;
            }
        }
        return res;
    }
    
}
