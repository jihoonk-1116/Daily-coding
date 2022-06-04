import java.security.cert.PolicyNode;
import java.util.*;

public class BfsDfs {

//    6
//    1 3 5 6 7
//    static int total;
//    static boolean flag = false;
//    static Stack<Integer> ans = new Stack<>();
//    public void q1(int[] arr){
//        total = Arrays.stream(arr).sum();
//        int index = 0;
//        q1Dfs(arr, 0, index);
//    }
//    private void q1Dfs(int[] arr, int curSum, int index){
//        //base case
//        //check if being equal current sum with total - current sum
//        //if true -> return ans
//        //to prevent proceeding more dfs use flag
//        if(flag) return;
//        if(index == arr.length){
//            if(curSum == total - curSum){
//                flag = true;
//                for(int v : ans){
//                    System.out.print(v);
//                }
//                return;
//            }
//        }
//        //dfs logic
//        else{
//            //add current index's value to current sum and invoke dfs
//            //search toward leftside
//            //LIFO
//            ans.add(arr[index]);
//            q1Dfs(arr, curSum + arr[index], index+1);
//            ans.pop();
//            //not add current index's value to current sum and invoke dfs
//            //search toward rightside
//            q1Dfs(arr, curSum, index+1);
//        }
//    }

    /*
     * 259 5
     * 81
     * 58
     * 42
     * 33
     * 61
     */
    //declare currentMax to find value as max as possible
//    static int curMax = 0;
//    public void q2(int[] input, int max){
//        //do dfs to find the answer
//        q2Dfs(input, max, 0, 0);
//        System.out.println("max = " + curMax);
//    }
//    private void q2Dfs(int[] input, int max, int cw, int index){
//        //base case
//        //compare current weight with max
//        //if current weight is greater than max
//        //then return since there is no need to add more weight, so stop searching
//        //compare current weight to current max
//        //if cw is greater than curMax, then curMax is assigned to cw
//        //if index == input.length, then return since the index points to out of the array.
//
//        if(cw <= max && cw > curMax) curMax = cw;
//        if(index == input.length || cw > max) return;
//        else{
//            //dfs logic
//            //add current value
//            q2Dfs(input, max, cw + input[index], index +1);
//            //not add current value
//            q2Dfs(input, max, cw, index+1);
//        }
//
//    }

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
    //the number of invoking dfs() is the number of children.
    // n = 3
    // 1 - 1
    // | \
    // 3  2
    // count for tracking the number of choices
    public void q4(int n){
        q4Dfs(n, 0, new int[3]);
    }
    // dfs(n,0)  dfs(n,1) dfs(n,2)
    // i = 1     i = 1    return -> 1,1
    // dfs(n, 1) dfs(n,2)
    //           i = 2    return -> 1,2
    //           dfs(n,2)
    //            i = 3   return -> 1,3
    //           dfs(n,2)
    // i = 2     repeat the same process
    // dfs(n, 1) ...
    private void q4Dfs(int n, int l, int[] pair){
        //base
        if(l == 3){
            for(int v : pair){
                System.out.print(v+1 + " ");
            }
            System.out.println();
        }
        else{
            for(int i =0;i<n;i++){
                pair[l] = i;
                q4Dfs(n, l+1, pair);
            }
        }
    }
    /*
        1 2 5
        15
     */
    static int q5Max = 15;
    static int q5CountMin = Integer.MAX_VALUE;
    public void q5(Integer [] input){
        Arrays.sort(input, Collections.reverseOrder());
        q5Dfs(input, 0, 0);
        System.out.println("q5CountMin = " + q5CountMin);
    }
    private void q5Dfs(Integer[] input, int curSum, int count){
        if(count > q5CountMin) return;
        if(curSum > q5Max) return;
        if(curSum == q5Max){
            if( q5CountMin > count){
                q5CountMin = count;
            }
        }
        else{
            for(int i=0;i<input.length;i++){
                q5Dfs(input, curSum + input[i], count+1);
            }
        }
    }
    //5 3
    //10

    //5 C 3 -> = 5 C 2 = 4 C 1 + 4 C 2
    //4 C 1 = 3 C 0 + 3 C 1
    //n and r -> r == 1 || r == 0 -> return 3 || 1
    //base case -> if(r == 1) return n;
    //dfs call  -> return dfs(n-1,r-1) + dfs(n-1, r);



    // 4 cases , 2 choices -> no duplicated value and pair
    // 12, 13, 14, 23, 24, 34
    //
    int[] pair;
    public void q7(int [] input, int level, int index){
        //base
        //level == 2 || checked number return
        if(level == 2) return;
        //dfs logic
        //do for by n
        else{
            for(int i=index;i<input.length;i++){
                //start with index argument to skip the same value
                pair[level] = i;
                q7(input, level+1, i+1);
            }
        }
        //check number
        //dfs
    }
    //dx = -1 0 1 0
    //dy =  0 1 0 -1
    /* start at 0,0  finish at 6,6
    //do not search out of index , value is 1
    //need to track current position because we need to start searching
    at the position. -> it means the next step
    0 0 0 0 0 0 0
    0 1 1 1 1 1 0
    0 0 0 1 0 0 0
    1 1 0 1 0 1 1
    1 1 0 0 0 0 1
    1 1 0 1 1 0 0
    1 0 0 0 0 0 0
     */
    //clockwise direction
//    static int[] dx = {-1,0,1,0};
//    static int[] dy = {0,1,0,-1};
//    static int ans = 0;
//    static int[][] board8 = new int[7][7];
//    public void q8(int x, int y){
//        //basecase
//        //value is 1 or not, reach out the end
//        if(x==7 && y==7) return;
//        else{
//            for(int i=0;i<4;i++){ //there are 4 cases that are able to choose...
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                if(nx < 0 || ny <0 || nx >= 7 || ny >= 7) continue;
//                if(board8[nx][ny] != 0) continue;
//                board8[nx][ny] = 1; //check the current pos
//                q8(nx,ny); //go to next
//                board8[nx][ny] = 0; //uncheck the current pos for the next search
//            }
//        }
//    }
    //find shortest path
    //not reach out - return -1
    //start at 0,0 end at 7,7
    /*
        0 0 0 0 0 0 0
        0 1 1 1 1 1 0
        0 0 0 1 0 0 0
        1 1 0 1 0 1 1
        1 1 0 1 0 0 0
        1 0 0 0 1 0 0
        1 0 1 0 0 0 0
     */
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void q9(int[][] board){
        int ans =0;
        Queue<Point> queue = new LinkedList<>();
        //stack for bfs
        queue.add(new Point(0,0));
        //add start position
        //use point class
        while (!queue.isEmpty()){
            Point tmp = queue.poll(); // current position
            //search 4 directions back, up, next, down
            //next direction is currentPos + dx, dy
            //do not search out of board, value is 1 -> only 0 can be routed
            //if board[x][y] is 0 , then add to stack for the next search.
            for(int i=0;i<4;i++){
                board[tmp.x][tmp.y] = 1; //check this position is visited
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx == 7 && ny == 7) { //if the next is the destination
                    ans++;
                    return;
                }
                if(nx < 0 || nx >= 7 || ny < 0 || ny >= 7 || board[nx][ny] == 1){
                    continue;
                }
                if(board[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                }
            }
            ans++;
        }
    }



    /*
    static int[] dx={-1, 0, 1, 0};
	static int[] dy={0, 1, 0, -1};
	static int[][] board;
	static int answer=0;

	public void DFS(int x, int y){
		if(x==7 && y==7) answer++;
		else{
			for(int i=0; i<4; i++){
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
					board[nx][ny]=1;
					DFS(nx, ny);
					board[nx][ny]=0;
				}
			}
		}
	}
     */

    public static void main(String[] args) {
        BfsDfs p = new BfsDfs();

//        int [] input = {1, 3, 5, 6, 7};
//        p.q1(input);

//        int [] input2 = {81,58,42,33,61};
//        int max = 259;
//        p.q2(input2, max);

//        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
//
//        int[] t = {5,12,8,3,4};
//        int[] s = {10,25,15,6,7};
//
//        for(int i=0;i<t.length;i++){
//            ArrayList<Integer> temp = new ArrayList<>();
//            temp.add(s[i]);
//            temp.add(t[i]);
//            input.add(temp);
//        }
//
//        p.q3(input);
//        p.q4(6);
            p.q5(new Integer[]{1,2,5});
    }

}
