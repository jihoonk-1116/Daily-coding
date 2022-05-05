import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
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

    /**
     * 352+*9-
     * 12
     */

    public static void q4(String str){

        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        while(index < str.length()){

            char c = str.charAt(index++);

            if(Character.isDigit(c)){
                stack.push(c-48);
            }
            else {
                int n1 = stack.pop();
                int n2 = stack.pop();

                if(c == '+') stack.push(n2 + n1);
                else if(c == '-')  stack.push(n2 - n1);
                else if(c == '*')  stack.push(n2 * n1);
                else if(c == '/')  stack.push(n2 / n1);
            }

        }

        ans = stack.pop();

        System.out.println("ans = " + ans);
    }

    /**
     * (((()(()()))(())()))(()())
     * 24
     */
    public static void q5(String str){
        //stack size - the number of irons
        //() -> lazer
        int ans = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == '(') stack.push(c);
            else{
                stack.pop();
                if(str.charAt(i-1) == '('){
                    ans += stack.size();
                }
                else if(str.charAt(i-1) == ')'){
                    ans += 1;
                }
            }
        }
        System.out.println("ans = " + ans);
    }

    /**
     * 8
     * 3
     *
     */
    public static void q6(int n, int k){

        int ans = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++){
            q.offer(i);
        }

        int cnt = 0;
        while(!q.isEmpty()){
            if(cnt < k - 1){
                q.offer(q.poll());
                cnt++;
            }else{
                ans = q.poll();
                cnt = 0;
            }
        }
        System.out.println(ans);
    }

    /**
     *
     * CBA
     * CBDAGE
     */
    public static void q7(String c, String r){

        Queue<Character> q = new LinkedList<>();

        for( char ch : r.toCharArray()){
            q.offer(ch);
        }

        for(char ch : c.toCharArray()){
            if(q.isEmpty()) {
                System.out.println("yes");
                return;
            }
            if(ch == q.peek()){
                q.poll();
            }
        }
        System.out.println("no");
    }

    /**
     * 2
     * 60 50 70 80 90
     */

    static class Person{

        int id;
        int priority;

        public Person(int id, int pri){
            this.id = id;
            this.priority = pri;
        }
    }
    public static void q8(int[] pl, int n){

        Queue<Person> q = new LinkedList<>();
        int ans = 1;

        for(int i=0;i<pl.length;i++){
            q.offer(new Person(i,pl[i]));
        }

        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person p : q){
                if(p.priority > tmp.priority){
                    q.offer(tmp);
                    break;
                }
            }
            if(tmp!=null){
                if(tmp.id == n) break;
                else ans ++;
            }
        }
        System.out.println(ans);

    }

    public static void main(String[] args) {
        //q1("(()(()))(())");
        //q2("(A(BC)D)EF(G(H)(IJ)K)LM(N)");
        //q3();
        //q4("352+*9-");
        //q5("()(((()())(())()))(())");
        //q6(8,3);
        q7("CBDAGE","CAB");
    }
}
