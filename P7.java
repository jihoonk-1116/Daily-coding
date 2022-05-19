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
     * 1 2 3
     * 1 2
     * 1 3
     * 1
     * 2 3
     * 2
     * 3
     */
    public void q6(){

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

        p7.q5(n);
    }
}
