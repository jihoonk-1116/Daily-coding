class Solution {
    public boolean isHappy(int n) {
        return happyNum(n);
//         Set<Integer> seen = new HashSet<>();
        
//         while(!seen.contains(n)){
            
//             seen.add(n);
//             n = sumOfSquare(n);
            
//             if(n == 1) return true;
           
//         }
//         return false;
    }
    
    private int sumOfSquare(int n){
        
        int sum = 0;
        
        while(n > 0){
            int first = n % 10;
            sum += (first * first);
            n = n / 10;
        }
        
        return sum;
    }
    
    private boolean happyNum(int n){
        int slow = n;
        int fast = sumOfSquare(n);
        
        while(slow != fast){
            fast = sumOfSquare(sumOfSquare(fast));
            slow = sumOfSquare(slow);
        }
        
        return fast == 1;
    }
}
