import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class BfsDfs {

//    6
//    1 3 5 6 7
    static int total;
    static boolean flag = false;
    static Stack<Integer> ans = new Stack<>();
    public void q1(int[] arr){
        total = Arrays.stream(arr).sum();
        int index = 0;
        q1Dfs(arr, 0, index);
    }
    private void q1Dfs(int[] arr, int curSum, int index){
        //base case
        //check if being equal current sum with total - current sum
        //if true -> return ans
        //to prevent proceeding more dfs use flag
        if(flag) return;
        if(index == arr.length){
            if(curSum == total - curSum){
                flag = true;
                for(int v : ans){
                    System.out.print(v);
                }
                return;
            }
        }
        //dfs logic
        else{
            //add current index's value to current sum and invoke dfs
            //search toward leftside
            //LIFO
            ans.add(arr[index]);
            q1Dfs(arr, curSum + arr[index], index+1);
            ans.pop();
            //not add current index's value to current sum and invoke dfs
            //search toward rightside
            q1Dfs(arr, curSum, index+1);
        }
    }

    /*
     * 259 5
     * 81
     * 58
     * 42
     * 33
     * 61
     */
    //declare currentMax to find value as max as possible
    static int curMax = 0;
    public void q2(int[] input, int max){
        //do dfs to find the answer
        q2Dfs(input, max, 0, 0);
        System.out.println("max = " + curMax);
    }
    private void q2Dfs(int[] input, int max, int cw, int index){
        //base case
        //compare current weight with max
        //if current weight is greater than max
        //then return since there is no need to add more weight, so stop searching
        //compare current weight to current max
        //if cw is greater than curMax, then curMax is assigned to cw
        //if index == input.length, then return since the index points to out of the array.

        if(cw <= max && cw > curMax) curMax = cw;
        if(index == input.length || cw > max) return;
        else{
            //dfs logic
            //add current value
            q2Dfs(input, max, cw + input[index], index +1);
            //not add current value
            q2Dfs(input, max, cw, index+1);
        }

    }

    /*
    5 20
    10 5
    25 12
    15 8
    6 3
    7 4
    */
    //do dfs to find the most suited case for the ans
    //the ans is that getting max score within the limited time
    static int lTime = 20;
    static int max2 = 0;
    public void q3(ArrayList<ArrayList<Integer>> input){
        q3Dfs(input, 0, 0,0);
        System.out.println("max2 = " + max2);
    }
    private void q3Dfs(ArrayList<ArrayList<Integer>> pSet, int curTime, int curScore, int index){
        //base case
        //compare current time with limited time
        //if current time is greater than the limited time
        //-> return, do nothing
        //if current time is less than the limited time
        //and current score is greater than the max score
        //max score is assigned to current one
        //we need to keep track of maxScore, curTime

        if(curTime > lTime){
            return;
        }
        if(pSet.size() == index){
            if(curScore > max2 ){
                max2 = curScore;
            }
        }
        //dfs logic
        else{
            //decide to solve the i's problem
            q3Dfs(pSet, curTime + pSet.get(index).get(1), curScore + pSet.get(index).get(0), index + 1);
            //decide not to solve the i's problem
            q3Dfs(pSet, curTime, curScore, index + 1);
        }

    }

    public static void main(String[] args) {
        BfsDfs p = new BfsDfs();

//        int [] input = {1, 3, 5, 6, 7};
//        p.q1(input);

//        int [] input2 = {81,58,42,33,61};
//        int max = 259;
//        p.q2(input2, max);

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        int[] t = {5,12,8,3,4};
        int[] s = {10,25,15,6,7};

        for(int i=0;i<t.length;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(s[i]);
            temp.add(t[i]);
            input.add(temp);
        }

        p.q3(input);

    }

}
