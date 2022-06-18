class Solution {
    public int evalRPN(String[] tokens) {
        //two integer
        //whenever find an operator -> pop twice
        //calculate by the operator then push the result
        
        Stack<String> st = new Stack<>();
        st.push(tokens[0]);
        int pos = 1;
        
        
        while(pos < tokens.length){
            //pop one token from the arry
            //check the token if it's an operator or numbers
            //if operator
            //then pop twice -> not need to check if it's empty since the RPN experssion is always valid
            //calculate them using operator
            //push the result
            //if num
            //then push
            String token = tokens[pos];
            int result = 0;
            
            if(token.equals("*") || token.equals("/") || token.equals("+")|| token.equals("-")){
                
                int op1 = Integer.parseInt(st.pop());
                int op2 = Integer.parseInt(st.pop());
                
                if(token.equals("*")) result = op2 * op1;
                else if(token.equals("/")) result = op2 / op1;
                else if(token.equals("-")) result = op2 - op1;
                else result = op2+op1;
                
                st.push(String.valueOf(result));
            }
            
            else{
                st.push(token);
            }
            
            pos ++ ;
        }
        
        return Integer.parseInt(st.pop());
    }
}
