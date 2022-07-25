class Solution {
    
    public int[] dailyTemperatures(int[] temperature){
        
        Stack<int[]> st = new Stack();
        int [] res = new int[temperature.length];
        
        for(int i=0;i<temperature.length;i++){
            
            while(!st.isEmpty() && st.peek()[0] < temperature[i]){
                int [] prevTemp = st.pop();
                res[prevTemp[1]] = i - prevTemp[1];
            }
            
            int[] curTemp = new int[]{temperature[i], i};
            st.push(curTemp);
            
        }
        
        return res;
        
    }
    
    
//     static class Temp{
        
//         public int value;
//         public int index;
        
//         public Temp(int v, int i){
//             this.value = v;
//             this.index = i;
//         }
        
//     }
    
    
//     public int[] dailyTemperatures(int[] temperatures) {
        
//         Stack<Temp> st = new Stack<>();
//         int [] res = new int[temperatures.length];
    
//         for(int i=0;i<temperatures.length;i++){
            
//             while(!st.isEmpty() && st.peek().value < temperatures[i]){
                    
//                     Temp t = st.pop();
//                     res[t.index] = i - t.index;
                
//                 }
//             st.push(new Temp(temperatures[i], i));
//         }
        
//         return res;
//     }
}
