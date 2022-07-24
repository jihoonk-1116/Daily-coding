class Solution {
    public boolean isValid(String s) {
        //char can be ( ) { } [] ;
        //stack
        //pop only if char == )
        //check the stack if it's empty 
        //empty -> t, otherwise -> f
        
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            
            char token = s.charAt(i);
            
            if(token == ')' || token == '}' || token == ']'){
                
                if(stack.isEmpty()) return false; 
                
                if(token == ')' && stack.peek() == '('){
                    stack.pop();
                }
                else if(token == '}' && stack.peek() == '{'){
                    stack.pop();
                }
                else if(token == ']' && stack.peek() == '['){
                    stack.pop();
                }
                else return false;
            }
            
            else stack.push(token);
        }
        
        return stack.isEmpty();
        
//         HashMap<Character, Character> closeToOpen = new HashMap<>();
        
//         closeToOpen.put(')','(');
//         closeToOpen.put('}','{');
//         closeToOpen.put(']','[');
        
//         for(int i=0;i<s.length();i++){
//             if(closeToOpen.containsKey(s.charAt(i))){ //close symbol 
//                 //validate if the close symbol is in correct order and pair
//                 if(!stack.isEmpty() && stack.peek() == closeToOpen.get(s.charAt(i))) {
//                     stack.pop();
//                 }
//                 else{
//                     return false;  
//                 }
//             }
//             else{
//                     stack.push(s.charAt(i));    
//             }
            
//         }
        
//         return stack.isEmpty();
    }
}
