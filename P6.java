import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P6 {

    /**
     * 6
     * 13 5 11 7 23 15
     * 5 7 11 13 15 23
     */
    //bubble
    public static void q1(int [] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
    //selection
    public static void q2(int[] arr){

        for(int i=0;i<arr.length -1 ;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void q3(int[] arr){
        for(int i=0;i<arr.length;i++){
            int tmp = arr[i], j;
            for(j=i-1;j>=0;j--){
                if(arr[j]>tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }
        for (int i : arr) {
            System.out.print(i +" ");
        }
    }
    /*
        8
        20 25 52 30 39 33 43 33
         */
    public static void q4(int[] arr){
        //sort the input array
        Arrays.sort(arr);
        //a loop for looking up duplicated value
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] == arr[i]) {
                System.out.println("D");
                return;
            }
        }
        System.out.println("U");
        //if there is a duplicated one, then return false and terminate the loop
        //else return true
    }

    public static void q5(int[] arr){
        //arr is already sorted
        //to find the switched values, check the value if it's between the prev and the next, arr[i-1] < arr[i] < arr[i+1]
        int c = -1,p = -1, count = 0;
        for(int i=1;i<arr.length;i++){
            if(i+1 == arr.length) break;
            if((arr[i-1] < arr[i]) && (arr[i] < arr[i+1])) continue;
            //then the first one to be found is ch because ch is taller than the p
            //so, the second one to be between the range should be p
            //how to assign the first and second -> use count

            if(count == 0) {
                count++;
                c = i;
            }
            else p = i;
        }
        System.out.println(c + "   " + p);
    }
    static class Value implements Comparable<Value>{

        private int x, y;

        public Value(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Value o) {
            if(this.x == o.x) return this.y - o.y; //should return 
            else return this.x - o.x;
        }
    }
    public static void q6(int[][] arr){

        ArrayList<Value> ans = new ArrayList<>();

        for(int[] value : arr){
            Value v = new Value(value[0], value[1]);
            ans.add(v);
        }
        Collections.sort(ans);
        for (Value an : ans) {
            System.out.println(an.x + "  " + an.y);
        }

    }
    public static void main(String[] args) {
        //q3(new int[] {13, 5, 11, 7, 23, 15});
        //q4(new int[] {20, 25, 52, 30, 39, 32, 43, 33});
        //q5(new int[]{120, 125, 152, 130, 135, 135, 143, 127, 160});
        q6(new int[][]{{2,7},{1,3},{1,2},{2,5},{3,6}});
    }
}
