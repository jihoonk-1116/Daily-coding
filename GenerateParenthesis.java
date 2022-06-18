class Solution {
    
    List<String> res = new ArrayList<>(); 
    Stack<String> st = new Stack<>();
    
    public List<String> generateParenthesis(int n) {
        //backtracking
        //track of the number of open and close parenthesis
        //if openP > closeP -> 
        //if n > openP -> add open or close by n
        
        backTrack(n, 0, 0,"");
        return res;
    }
    
    private void backTrack(int n, int numOpen, int numClose, String s){
        
        if( n == numClose){
            // String temp = "";
            // for(String s : st){
            //     temp += s;
            // }
            // res.add(temp);
            res.add(s);
            return;
        }
        
        if(n > numOpen){ //can add more open ,
           // st.push("("); //choosed adding open so push open
            backTrack(n, numOpen + 1, numClose, s + "("); //invoke method for next choice
           // st.pop(); //make to another choice 
        }
        
        if(numOpen > numClose){ //num of close should be depended on the num of open
           // st.push(")");
            backTrack(n, numOpen, numClose+1, s + ")");
           // st.pop();
        }
        
    }
}
