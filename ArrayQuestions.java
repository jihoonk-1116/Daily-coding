import java.util.ArrayList;

public class p2{

    public static class Problems{

        public Problems(){}

        public static void q1(){

            int [] input = {7,3,9,5,6,12};
            ArrayList<Integer> ans =  new ArrayList<>();
            ans.add(input[0]);

            for(int i =0;i<input.length-1;i++){
                if(input[i] < input[i+1]){
                    ans.add(input[i+1]);
                }
            }
            System.out.println(ans);

        }

        public static void q2(){
            int [] input = {130, 135, 148, 140, 145, 150, 150, 153};
            int maxHeight = input[0];
            int ans = 1;

            for(int i = 1;i<input.length;i++){
                if(input[i] > maxHeight){
                    maxHeight = input[i];
                    ans++;
                }
            }
            System.out.println("ans = " + ans);

        }

        /**
         * 1-S , 2-R , 3-P
         *23313 11223
         */

        public static void q3(){
            int[] a_input = {2,3,3,1,3};
            int[] b_input = {1,1,2,2,3};

            for(int i=0;i<a_input.length;i++){
                if(a_input[i] == b_input[i]){
                    System.out.println("D");
                }
                else if(a_input[i] == 1 && b_input[i]== 3){
                    System.out.println("A");
                }
                else if(a_input[i] == 2 && b_input[i]== 1){
                    System.out.println("A");
                }
                else if(a_input[i] == 3 && b_input[i]== 2){
                    System.out.println("A");
                }
                else
                    System.out.println("B");
            }

        }

        /**
         * Pibonacci
         * n = 10, output - 1 1 2 3 5 8 13 21 34 55
         */

        public static void q4(){
            int a = 1; //0
            int b = 1; //1
            int c;     //2

            for(int i=2;i<10;i++){
                c = a + b;
                System.out.println("c = " + c);
                a = b;
                b = c;
            }


            int n = 10;
            int [] ans = new int[n];
            ans[0] = 1;
            ans[1] = 1;

            for(int i=2;i<n;i++){
                ans[i] = ans[i-2] + ans[i-1];
            }

            for(int d : ans){
                System.out.println("d = " + d);
            }
        }

        /**
         * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력
         */

        public static void q5(int n){

            ArrayList<Integer> ans = new ArrayList<>();
            int [] checkArr = new int[n+1]; // n+1 to check n cuz array starts at 0
            for(int i=2;i<=n;i++){
                if(checkArr[i]== 0){
                    ans.add(i);
                    for(int j=i;j<=n;j=j+i){  //check i's multiple
                        checkArr[j] = 1;
                    }
                }
            }
            System.out.println("ans = " + ans);
        }
        /**
         * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력
         * input -
         * 9
         * 32 55 62 20 250 370 200 30 100
         * output
         * 23 2 73 2 3
         */
        private static boolean isPrime(int n){
            if(n==1 || n==0) return false;
            for(int i=2;i<n;i++){
                if(n%i == 0) return false;
            }
            return true;
        }
        public static void q6(int n, int [] arr){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0;i<n;i++){
                int curNum = arr[i];
                int revNum = 0;
                while(curNum>0){
                    int m = curNum%10;      //extract 1's place
                    revNum = revNum*10 + m; //round up the previous extracted num as 10's place and add m
                    curNum = curNum/10;     //remove 1's place from current number
                }
                if(isPrime(revNum)) ans.add(revNum);
            }
            System.out.println("ans = " + ans);
        }
        /**
         * 첫째 줄에 입력에서 주어진 채점 결과에 대하여 가산점을 고려한 총 점수를 출력한다.
         * 10 
         * 1011100110
         */
        public static void q7(){

            int[] input = {1,0,1,1,1,0,0,1,1,0};
            int ans = 0, curCum=0;

            for(int n : input){
                if(n == 1) {
                    curCum++;
                    ans += curCum;
                }
                else
                    curCum = 0;
            }

//            for(int n : input){
//                if(n == 0)
//                {
//                    curCum = 0;
//                }
//                else if(curCum > 0)
//                { //1,2,3... it means that previous question(s) was correct.
//                    curCum++;
//                    ans += curCum;
//                }
//                else
//                {
//                    ans += 1;
//                    curCum++;
//                }
//            }
            System.out.println("ans = " + ans);
        }
    }

    public static void main(String[] args) {
        //Problems.q5(20);
        //Problems.q6(9,new int[] {32, 55, 62, 20, 250, 370, 200, 30, 100});
        Problems.q7();
    }
}
