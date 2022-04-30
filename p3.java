import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p3 {

    /**
     * 3
     * 1 3 5
     * 5
     * 2 3 6 7 9
     * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력
     */
    static public void q1(){
        int [] input1 = {2,3,6,7,9};
        int [] input2 = {1,3,5};
        ArrayList<Integer> ans = new ArrayList<>();

        int p1=0,p2=0;
        while(p1<input1.length || p2<input2.length){
            if(p1 < input1.length && p2<input2.length){
                if(input1[p1] < input2[p2]){
                    ans.add(input1[p1++]);
                }else{
                    ans.add(input2[p2++]);
                }
            }
            else if(p1 < input1.length){
                ans.add(input1[p1++]);
            }
            else{
                ans.add(input2[p2++]);
            }
        }

        System.out.println("ans = " + ans);


    }

    /**
     * 두 집합의 공통 원소를 추출
     * 5
     * 1 3 9 5 2
     * 5
     * 3 2 5 7 8
     */
    public static void q2(){
        int[] arr1 = {1,3,9,5,2};
        int[] arr2 = {3,2,5,7,8};
        //two pointers alg must be used with sorted array!
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0,p2 = 0;

        while(p1 < arr1.length && p2 < arr2.length){
            if(arr1[p1] == arr2[p2]){
                ans.add(arr1[p1]);
                p1++;
                p2++;
            }
            else if(arr1[p1] < arr2[p2]){
                p1++;
            }
            else {
                p2++;
            }
        }
        System.out.println("ans = " + ans);
    }

    /**
     * K일 동안의 최대 매출액
     * 10 3
     * 12 15 11 20 25 10 20 19 13 15
     */
    public static void q3(int k){
        int[] input = {12,15,11,20,25,10,20,19,13,15};
        int sum =0, ans=0;

        for(int i=0;i<input.length;i++){
            if(i + 1 <= k){
                sum += input[i];
            }
            else{
                sum = sum + input[i] - input[i-k];
                ans = Math.max(ans, sum);
            }
        }
        System.out.println("ans = " + ans);
    }

    /**
     * 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번
     * 8 6
     * 1 2 1 3 1 1 1 2
     */
    public static void q4(int target){
        int [] input = {1,2,1,3,1,1,1,2};
        int lt=0,rt=0;
        int sum =0, cnt=0;

        while(lt < input.length){
            if(rt<input.length && sum < target){
                sum+=input[rt++];
            }
            if(sum > target){
                sum-=input[lt++];
            }
            else if(sum == target){
                cnt++;
                sum -= input[lt++];
            }
            if(rt >= input.length && sum < target){
                break;
            }
        }
        System.out.println("cnt = " + cnt);

        cnt = sum = lt = 0;
        for(int rp=0;rp<input.length;rp++){
            sum += input[rp];
            if(sum == target) cnt++;
            while(sum > target){
                sum -= input[lt++];
                if(sum == target) cnt++;
            }
        }
        System.out.println("cnt = " + cnt);
    }

    /**
     * N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현
     * 15
     * 3
     */
    public static void q5(int n){
        int m = n/2 + 1;
        int [] arr = new int[m];

        for(int i=0;i<m;i++) arr[i] = i+1;

        int lt = 0, ans = 0, sum = 0;

        for(int rt=0;rt<m;rt++){

            sum += arr[rt];

            if(sum == n) ans++;

            while(sum >= n){
                sum -= arr[lt++];
                if(sum == n) ans++;
            }

        }
        System.out.println(ans);
    }

    /**
     * 1로만 구성된 최대 길이의 연속부분수열
     * 14 2
     * @param n try
     * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
     * lt->lt
     */
    public static void q6(int n){
        /**
         * int answer=0, cnt=0, lt=0;
         * 		for(int rt=0; rt<n; rt++){
         * 			if(arr[rt]==0) cnt++;
         * 			while(cnt>k){
         * 				if(arr[lt]==0) cnt--;
         * 				lt++;
         *                        }
         * 			answer=Math.max(answer, rt-lt+1);* 		}
         */
        int[] input = {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
        int ans=0,cnt = 0;
        int lt = 0;

        for(int rt=0;rt<input.length;rt++){
//            if(input[rt] == 1) ans = Math.max(ans,rt-lt+1);
            if(input[rt] == 0 && cnt < n){
                cnt++;
            }
            ans = Math.max(ans,rt-lt+1);
            if(cnt == n){
                while(input[lt]==1){
                    lt++;
                }
                cnt--;
            }
        }
        System.out.println("ans = " + ans);
    }

    public static void main(String[] args) {
        q6(2);
    }
}
