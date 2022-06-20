class Solution {
    
    static class Temp{
        
        public int value;
        public int index;
        
        public Temp(int v, int i){
            this.value = v;
            this.index = i;
        }
        
    }
    
    public int[] dailyTemperatures(int[] temperatures) {
        //stack -> LIFO 
        //push one by one
        //compare current and top one of stack
        //if current value is higher than the one.
        //then pop and insert answer using lt 
        //increae lt whenever it's used
        //monotonic stack -> a stack formed in decrasing order
        
        Stack<Temp> st = new Stack<>();
        int [] res = new int[temperatures.length];
    
        for(int i=0;i<temperatures.length;i++){
            
            while(!st.isEmpty() && 
                  st.peek().value < temperatures[i]){
                    
                    Temp t = st.pop();
                    res[t.index] = i - t.index;


                }
            st.push(new Temp(temperatures[i], i));
        }
        
        return res;
    }
}
