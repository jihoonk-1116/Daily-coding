class Solution {
    
    List<String> res = new ArrayList<>(); 
    Stack<String> st = new Stack<>();
    
    public List<String> generateParenthesis(int n) {
        backTrack(n, 0, 0);
        return res;
    }
    
    private void backTrack(int n, int numOpen, int numClose){
        
        if( n == numClose){
            String temp = "";
            for(String s : st){
                temp += s;
            }
            res.add(temp);
            return;
        }
        
        if(n > numOpen){ //can add more open ,
            st.push("("); //choosed adding open so push open
            backTrack(n, numOpen + 1, numClose); //invoke method for next choice
            st.pop(); //make to another choice 
        }
        
        if(numOpen > numClose){ //num of close should be depended on the num of open
            st.push(")");
            backTrack(n, numOpen, numClose+1);
            st.pop();
        }
        
    }
}


class Solution {
    
    List<String> res = new ArrayList<>(); 
    
    public List<String> generateParenthesis(int n) {
        backTrack(n, 0, 0,"");
        return res;
    }
    
    private void backTrack(int n, int numOpen, int numClose, String s){
        
        if( n == numClose){
            res.add(s);
            return;
        }
        
        if(n > numOpen){ //can add more open ,
            backTrack(n, numOpen + 1, numClose, s + "("); //invoke method for next choice
        }
        
        if(numOpen > numClose){ //num of close should be depended on the num of open
            backTrack(n, numOpen, numClose+1, s + ")");
        }
        
    }
}
