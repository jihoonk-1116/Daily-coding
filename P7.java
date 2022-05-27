import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P7 {

    //print from 1 to n
    //3

    int[] arr = new int[100];
    public void q1(int n){
        q1Helper(n);
    }

    //
    private void q1Helper(int n){
        //base case : n = 0
        if(n == 0) return;
        //logic : print and decrement
        System.out.println(n);
        arr[n] = n;
        q1Helper(n-1);
        //System.out.println(n);
    }

    //10
    //10 / 2 :  5.. 0
    //5 / 2 : 2..1
    //2 / 2 : 1 .. 0
    //1 / 2 : 0 .. 1
    // 1 0 1 0
    // dfs, do logic after invoking recur
    public void q2(int n){
        q2Recur(n);
    }
    private void q2Recur(int n){
        if(n == 0) {
            return;
        }
        //--top process first
        //System.out.print(n%2 + " ");
        //--top process first
        q2Recur(n/2);
        //--bottom process first
        System.out.print(n%2 + " ");
        //--bottom process first
    }

    public void q3(int n){
        System.out.println(q3Helper(n));
    }
    private int q3Helper(int n){
        if(n == 1) return 1;
        return n * q3Helper(n-1);
        //f(5) = 5 * f(4) = 5 * 4 * 3 * 2 * 1
        //f(4) = 4 * f(3) = 4 * 3 * 2 * 1
        //f(3) = 3 * f(2) = 3 * 2 * 1
        //f(2) = 2 * f(1) = 2 * 1
        //f(1) = 1
    }

    public void q4(int n){
        int [] table = new int[n+1];
        table[1] = 1;
        table[2] = 1;
        System.out.println(pibo(n, table));
    }
    private int pibo(int n, int[] table){
        //if(n == 1 || n == 2) return 1;
        if(table[n] != 0) return table[n];
        return table[n] = pibo(n-1, table) + pibo(n-2, table);
    }
    //3

    private static class Node{
        public int v;
        public Node l;
        public Node r;

        public Node(int n){
            this.v= n;
        }
    }

    public void q5(Node root){
        traverse(root);
    }
    private void traverse(Node n){
        if(n == null) return;

        System.out.print(n.v + " ");
        traverse(n.l);
        traverse(n.r);
    }

    /**
     * 1 2 3 .
     * 1 2 .
     * 1 3 .
     * 1 .
     * 2 3 .
     * 2 .
     * 3 .
     */
    /**
     *  yes  1 no
     *     /  \
     *    2    2
     *   / \  / \
     *  3  3 3  3
     *
     */
    public void q6(int n){
        int[] cases = new int[n+1];
        q6Helper(n,cases);
    }
    private void q6Helper(int n, int[] cases){
        if(n == 0){
            for(int d : cases){
                if(d > 0)
                    System.out.print(d);
            }
            System.out.println();
            return;
        }
        cases[n] = n;
        q6Helper(n-1, cases);
        cases[n] = -1;
        q6Helper(n-1, cases);
    }

    public void q7(Node root){
        q7LevelOrder(root);
    }
    private void q7LevelOrder(Node n){

        Queue<Node> s = new LinkedList<>();
        s.add(n);

        while(!s.isEmpty()){
            for(int i=0;i<s.size();i++){
                Node t = s.poll();
                System.out.print(t.v + " ");
                if(t.l != null) s.add(t.l);
                if(t.r != null) s.add(t.r);
            }
        }

    }

    public void q8(int s, int t){
        Queue<Integer> q = new LinkedList<>();
        int [] dx = {1, -1, 5};
        int [] mem =  new int[1001];
        q.offer(s);
        int step = 0;
        //cases : 1 -1 5
        //so we need to make three branches for each case
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size;i++){
                int cur = q.poll();
//                if(cur == t) {
//                    System.out.println("Step == " + step);
//                    return;
//                }
                for(int d :dx){
                    int nextX = cur + d;
                    if(nextX == t) {

                        System.out.println("Step == " + ++step);
                        return;
                    }
                    if(nextX >= 1 && nextX <= 1000 && mem[nextX] == 0){
                        mem[nextX] = nextX;
                        q.offer(nextX);
                    }
                }
//                q.offer(cur + 1);
//                q.offer(cur - 1);
//                q.offer(cur + 5);
            }
            step ++;
        }
    }

    public void q9(Node root){
        //do level search
        //the number of levels represents edge
        //find the closest leaf node
        //if there are no children of a node
        //then it is a leaf node

        //do level search

        //use 'if' statement to detect if is a leaf node
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int e=0;

        while(!q.isEmpty()){
            int len = q.size();
            e++;
            for(int i = 0;i<len;i++){
                //poll a node from the q
                Node n = q.poll();
                //if : the node has children
                if(n.l == null && n.r == null){
                    System.out.println(e);
                    return;
                }
                //else : add its children to the q
                q.offer(n.l);
                q.offer(n.r);
            }
            //out of the for loop -> increase the number of edges
        }
        //end while
    }
    /*

    5 9
    1 2
    1 3
    1 4
    2 1
    2 3
    2 5
    3 4
    4 2
    4 5
        6

        {
            {0,1,1,1,0},
            {1,0,1,0,1},
            {0,0,0,1,0},
            {0,1,0,0,1},
            {0,0,0,0,0}
        }
     */
    static int ans = 0;
    static int len = 0; //the number of edges
    static int[] ch; //check if visiting or not
    Queue<Integer> q = new LinkedList<>();
    public void q10(int[][] g){
        ch = new int[g.length];
        ch[0] = 1;
        len = g.length;
        dfs(0, g);
        System.out.println(ans); //starting point
    }
    private void dfs(int v, int[][] g){
        if(v == 4)
            //g.len - 1
            //end of the graph
        {
            ans++;
            q.offer(v+1);
            System.out.println(q.toString());
            q.clear();
            return;
        }
        for(int i =0;i<len;i++){

            if(g[v][i] == 1 && ch[i] == 0){
                ch[i] = 1; //check node i is visited
                q.offer(v+1);
                dfs(i, g);
                ch[i] = 0; //check node i is not visited for the next path searching
            }
        }
    }

    public static void main(String[] args) {
        P7 p7 = new P7();
        //p7.q4(3);

        Node n = new Node(1);
        n.l = new Node(2);
        n.r = new Node(3);
        n.l.l = new Node(4);
        n.l.r = new Node(5);
        n.r.l = new Node(6);
        n.r.r = new Node(7);

        Node n2 = new Node(1);
        n2.l = new Node(2);
        n2.r = new Node(3);
        n2.l.l = new Node(4);
        n2.l.r = new Node(5);
        n2.r.l = new Node(6);
        n2.r.r = new Node(7);
        n2.l.l.l = new Node(8);
        n2.l.l.r = new Node(9);


        //p7.q7(n);
        //p7.q8(5, 14);

        //p7.q9(n2);

        int [][] graph =
                    {
                        {0,1,1,1,0},
                        {1,0,1,0,1},
                        {0,0,0,1,0},
                        {0,1,0,0,1},
                        {0,0,0,0,0}
                    };

        p7.q10(graph);


    }
}
