import java.util.Stack;

public class P5 {
    /**
     * 올바른 괄호의 쌍
     * (()(()))(()
     * out - false
     */
    public static void q1(String str){

        Stack<Character> stack = new Stack<>();
        boolean ans = true;

        for(char c : str.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else{
                if(stack.pop() == '('){
                    continue;
                }
                ans = false;
                break;
            }
        }

        if(!stack.isEmpty())
            ans = false;

        System.out.println(ans);
    }

    /**
     * 소괄호 ( ) 사이에 존재하는 모든 문자를 제거
     * (A(BC)D)EF(G(H)(IJ)K)LM(N)
     * EFLM
     */
    public static void q2(String str){

        Stack<Character> stack = new Stack<>();
        String ans = "";
        String ans2 = "";

        for(char c : str.toCharArray()){

            if(stack.isEmpty() && Character.isAlphabetic(c)) {
                ans += c;
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                stack.pop();
            }
        }

        for(char c : str.toCharArray()){
            if(c == ')'){
                while(stack.pop() != '(' ){}
            }
            else{
                stack.push(c);
            }
        }

        for(char c : stack){
            System.out.print(c);
        }

        /**
         * String answer="";
         * Stack<Character> stack=new Stack<>();
         * for(char x : str.toCharArray()){
         * 	   if(x==')'){
         * 		  while(stack.pop()!='(');
         *     }
         * 	   else stack.push(x);*
         * }
         * for(int i=0; i<stack.size(); i++)
         *        answer+=stack.get(i);
         *
         */

        //System.out.println("ans = " + ans);
    }


//    5
//    0 0 0 0 0
//    0 0 1 0 3
//    0 2 5 0 1
//    4 2 4 4 2
//    3 5 1 3 1
//    8
//    1 5 3 5 1 2 1 4


    public static void q3(){
        //4 3 1 1 3 2 - 4
        int [] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int [][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for( int m : moves){
            for(int i=0;i<board.length;i++){
                if(board[i][m-1] == 0) continue;
                else{
                    if(!stack.isEmpty() && stack.peek() == board[i][m-1]){
                        ans += 2;
                        stack.pop();
                    }
                    else{
                        stack.push(board[i][m-1]);
                    }
                    board[i][m-1] = 0;
                    break;
                }
            }

        }
        System.out.println("ans = " + ans);

    }


    public static void main(String[] args) {
        //q1("(()(()))(())");
        //q2("(A(BC)D)EF(G(H)(IJ)K)LM(N)");
        q3();
    }
}
