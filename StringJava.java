import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class p1 {
    /**
     * Q1. 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요. 문장속의 각 단어는 공백으로 구분됩니다.
     */
    static public class Q1 {

        String s = "Pro is so fun and useful";

        public Q1() {
        }

        public void q1_1() {
            // without split()

            String temp = "";
            String longestWord = "";

            for (char c : this.s.toCharArray()) {
                if (c == ' ') {
                    temp = "";
                    continue;
                }
                temp += c;
                if (longestWord.length() < temp.length()) {
                    longestWord = temp;
                }
            }
            System.out.println(longestWord);
        }

        // using split()
        public void q1_2() {
            String[] strArr = s.split(" ");
            String longestStr = "";
            for (String str : strArr) {
                if (longestStr.length() < str.length()) {
                    longestStr = str;
                }
            }
            System.out.println(longestStr);
        }

        // indexOf and subString
        public void q1_3() {
            String ans = "";
            int pos = 0;

            while ((pos = s.indexOf(' ')) != -1) { // indexOf(' ') -> return an index that is the first space
                // if -1 , then there is no more space!

                String tmp = s.substring(0, pos);
                if (ans.length() < tmp.length()) {
                    ans = tmp;
                }
                s = s.substring(pos + 1); // update s to find the next space
            }
            if (ans.length() < s.length()) {
                ans = s;
            }
            System.out.println("Q1_3 ======  " + ans);
        }
    }

    /**
     * Q2. 해당 특정문자가 입력받은 문자열에 몇 개 존재
     */

    static public class Q2 {

        String str = "This is amazing america";

        public Q2() {
        }

        public void q2_1(char target) {
            // when target.length == 1
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == target) {
                    count++;
                }
            }
            System.out.println("Ans " + count);
        }

    }

    /**
     * Q3. 대문자는 소문자로 소문자는 대문자로 변환
     */
    static public class Q3 {

        String str = "Study HarD";

        public Q3() {

        }

        public void q3_1() {
            String ans = "";
            for (char c : str.toCharArray()) {

                if (c == ' ') {
                    ans += ' ';
                    continue;
                }

                if (Character.isLowerCase(c)) {
                    ans += Character.toUpperCase(c);
                } else {
                    ans += Character.toLowerCase(c);
                }
            }
            System.out.println("Q3 ===== " + ans);
        }
    }

    /**
     * Q4. N개의 단어가 주어지면 각 단어를 뒤집어 출력
     */
    static public class Q4 {

        private String[] strArr = {"hi", "jihoon", "great", "sam"};

        public Q4() {
        }

        // StringBuilder , reverse()
        public void q4_1() {
            ArrayList<String> ans = new ArrayList<>();
            for (String str : strArr) {
                StringBuilder sb = new StringBuilder(str);
                sb.reverse();
                String tmp = sb.toString();
                ans.add(tmp);
            }
            for (String str : ans) {
                System.out.println(str);
            }
        }

        // without reverse
        public void q4_2() {

            ArrayList<String> ans = new ArrayList<>();
            for (String str : strArr) {
                int lt = 0, rt = str.length() - 1;
                char[] tmp = str.toCharArray();
                while (lt < rt) {
                    tmp[lt] = str.charAt(rt);
                    tmp[rt] = str.charAt(lt);
                    lt++;
                    rt--;
                }
                ans.add(String.valueOf(tmp));
            }
            for (String s : ans) {
                System.out.println(s);
            }
        }
    }

    // 영어 알파벳만 뒤집고, 특수문자는 자기 자리에 그대로 있는 문자열
    static public class Q5 {
        String str = "a#b!GE*T@S";

        public Q5() {

        }

        public void q5_1() {
            int lt = 0, rt = str.length() - 1;
            char[] ans = new char[str.length()];
            char[] cArr = str.toCharArray();
            while (lt < rt) {
                if (Character.isAlphabetic(str.charAt(lt))) {
                    if (Character.isAlphabetic(str.charAt(rt))) {
                        ans[lt] = cArr[rt];
                        ans[rt] = cArr[lt];
                        lt++;
                        rt--;
                    }
                } else {
                    ans[lt] = cArr[lt];
                    ans[rt] = cArr[rt];
                    lt++;
                    rt--;
                }
            }
            System.out.println(String.valueOf(ans));
        }
    }

    static public class Q6 {
        // 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거
        private String input = "ksekkset";

        public Q6() {

        }

        public void q6_1() {

            HashSet<Character> set = new HashSet<>();
            String ans = "";

            for (char c : input.toCharArray()) {
                if (!set.add(c)) {
                    continue;
                }
                ans += c;
            }
            System.out.println(ans);
        }

        public void q6_2() {

            String ans = "";

            for (int i = 0; i < input.length(); i++) {
                if (input.indexOf(input.charAt(i)) == i)
                    ans += input.charAt(i);

            }

            System.out.println(ans);
        }
    }

    // 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"

    static public class Q7 {

        private String input = "goaoG";

        public Q7() {

        }

        public void q7_call() {

            System.out.println(q7());
            System.out.println("q7 =====" + q7_3());
        }

        // two pointers
        public boolean q7() {

            int l = 0, r = input.length() - 1;
            input = input.toLowerCase();

            while (l < r) {

                if (input.charAt(l) != input.charAt(r))
                    return false;

                l++;
                r--;
            }
            return true;
        }

        // Stringbuilder reverse
        public boolean q7_2() {

            String tmp = new StringBuilder(input).reverse().toString();

            if (tmp.equalsIgnoreCase(input))
                return true;

            return false;
        }

        public boolean q7_3() {

            String str = "found7, time: study; Yduts; emit, 7Dnuof";

            str = str.toLowerCase();
            str = str.replaceAll("[^a-z]", "");

            System.out.println(str);

            String tmp = new StringBuilder(str).reverse().toString();

            System.out.println(tmp);

            // don't use "==" operation for comparing String object!
            if (tmp.equals(str))
                return true;

            return false;

        }
    }

    public static class Q8 {

        public Q8() {

        }

        // 자연수 추출
        public void q8() {
            String str = "g0en2T0s8eSoft";
            String ans = "";

            for (char c : str.toCharArray()) {
                if (Character.isDigit(c))
                    ans += c;
            }
            System.out.println(Integer.valueOf(ans));
            System.out.println(Integer.valueOf(str.replaceAll("[^0-9]", "")));
        }

    }

    public static class Q9 {
        public Q9() {

        }

        // 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리
        public void q9() {

            String str = "teachermode";
            char letter = 'e';
            int[] ans = new int[str.length()];
            int p = 1000;

            for (int i = 0; i < str.length(); i++) {
                p++;
                if (str.charAt(i) == letter) {
                    p = 0;
                    ans[i] = 0;
                } else {
                    ans[i] = p;
                }
            }

            p = ans[ans.length - 1];

            for (int i = str.length() - 1; i >= 0; i--) {

                p++;

                if (str.charAt(i) != letter && ans[i] > p) {
                    ans[i] = p;
                    /// ans[i] = Math.min(ans[i], p);
                } else {
                    p = 0;
                }
            }

            for (int n : ans) {
                System.out.print(n + " ");
            }
        }

        // 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법
        public void q10() {

            String str = "KKHSSSSSSSE";
            HashMap<Character, Integer> map = new HashMap<>();

            for (char c : str.toCharArray()) {
                if (!map.containsKey(c)) {
                    Integer n = 1;
                    map.put(c, n);
                } else {
                    map.put(c, map.get(c) + 1);
                }
            }

            ArrayList<String> ans = new ArrayList<>();
            char pre = str.charAt(0);

            for (int i = 0; i < str.length(); i++) {
                if (pre != str.charAt(i) || i == 0) {
                    ans.add(String.valueOf(str.charAt(i)));
                    ans.add(String.valueOf(map.get(str.charAt(i))));
                }
                pre = str.charAt(i);
            }

            System.out.println(ans.toString().replaceAll("[^2-9^A-Z]", ""));
        }

        public void q10_1() {
            String str = "KKHSSSSSSSE";

            String ans = "";
            int count = 1;

            str = str + " ";

            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                } else {
                    ans += str.charAt(i);
                    if (count == 1) {
                        continue;
                    }
                    ans += String.valueOf(count);
                    count = 1;
                }
            }
            System.out.println(ans);
        }

        /**
         * n = 4 , s = #****###**#####**#####**##**
         * 7 digits
         * # -> 1 , * -> 0
         */
        public void q11() {
            int n = 4;
            String str = "#****###**#####**#####**##**";
            String ans = "";

            for (int i = 0; i < n; i++) {
                String tmp = str.substring(0, 7);
                tmp = tmp.replace("#", "1")
                        .replace("*", "0");
                System.out.println(tmp);
                //System.out.println((char) Integer.parseInt(tmp,2));
                ans += (char) Integer.parseInt(tmp, 2);
                str = str.substring(7);
            }
            System.out.println(ans);
        }

        /**
         * 5
         * 87 89 92 100 76
         * out - 43215
         */
        public void q12(int[] arr) {

            int[] ans = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {

                int cnt = 1;

                for (int j = 0; j < arr.length; j++) {

                    if (arr[i] < arr[j]) cnt++;
                }

                ans[i] = cnt;

            }
            for (int i : ans) {
                System.out.println("i = " + i);
            }
        }

        /**
         * 10 13 10 12 15
         * 12 39 30 23 11
         * 11 25 50 53 15
         * 19 27 29 37 27
         * 19 13 30 13 19
         * <p>
         * out - 155
         */
        public void q13(int n) {
            int[][] input = {
                    {10, 13, 10, 12, 15},
                    {12, 39, 30, 23, 11},
                    {11, 25, 50, 53, 15},
                    {19, 27, 29, 37, 27},
                    {19, 13, 30, 13, 19}
            };
            int sum1, sum2, ans = 0;
            for (int i = 0; i < n; i++) {
                sum1 = sum2 = 0;
                for (int j = 0; j < n; j++) {
                    sum1 += input[i][j];
                    sum2 += input[j][i];
                }
                ans = Math.max(sum1, ans);
                ans = Math.max(sum2, ans);
            }
            sum1 = sum2 = 0;
            for (int i = 0; i < n; i++) {
                sum1 += input[i][i];
                sum2 += input[i][n - i - 1];
            }

            ans = Math.max(sum1, ans);
            ans = Math.max(sum2, ans);

            System.out.println("ans = " + ans);
        }

        /**
         * 53723
         * 37161
         * 72534
         * 43641
         * 87352
         * out - 10
         */
        public void q14() {
            int[][] input = {
                    {5, 3, 7, 2, 3},
                    {3, 7, 1, 6, 1},
                    {7, 2, 5, 3, 4},
                    {4, 3, 6, 4, 1},
                    {8, 7, 3, 5, 2}
            };
            //         (0,1)
            //           ^
            // (-1,0) <     > (1,0)
            //           |
            //         (0,-1)
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            int ans = 0;

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input.length; j++) {

                    boolean flag = true;
                    for (int k = 0; k < 4; k++) {

                        int cx = i + dx[k];
                        int cy = j + dy[k];

                        if (cx >= 0 && cx < input.length && cy >= 0 && cy < input.length) {
                            if (input[cx][cy] >= input[i][j]) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag == true) {
                        ans++;
                    }
                }
            }
            System.out.println("ans = " + ans);
        }

        public void q15() {
            int[][] input = {
                    {2, 3, 1, 7, 3},
                    {4, 1, 9, 6, 8},
                    {5, 5, 2, 4, 4},
                    {6, 5, 2, 6, 7},
                    {8, 4, 2, 2, 2}
            };
            int ans = 0;
            for (int curStu = 0; curStu < input.length; curStu++) {
                int count = 0;
                for (int compStu = 0; compStu < input.length; compStu++) {
                    for (int stuClass = 0; stuClass < input.length; stuClass++) {
                        if (input[curStu][stuClass] == input[compStu][stuClass]) {
                            count++;
                            break;
                        }
                    }
                }
                if (ans < count) {
                    ans = count;
                }
            }
            System.out.println("ans = " + ans);

        }
         public void q16(){
            int [][] input = {
                    {3,4,1,2},
                    {4,3,2,1},
                    {3,1,4,2}
            };
            int ans = 0;
            //1. pick 2 student
            //2. look up a test and find their score
            //3. compare the scores
            //4. if st1 has higher score, cnt++
            //5. if cnt = 3, which means st1 is higher than st2 at the all tests,
            //   then, increase ans. or save (st1, st2)
            for(int st1=0;st1<input[0].length;st1++){
                for(int st2=0;st2<input[0].length;st2++){
                    int cnt = 0;
                    for(int test=0;test<input.length;test++){

                        int st1Rank = 0, st2Rank = 0;

                        for(int score=0;score<input[0].length;score++){
                            if(input[test][score]==(st1+1)) st1Rank = score;
                            if(input[test][score]==(st2+1)) st2Rank = score;
                        }
                        if(st1Rank < st2Rank) cnt++;
                    }
                    if(cnt == input[0].length){
                        ans++;
                    }
                }
            }
            System.out.println("ans = " + ans);
        }

        public static void main(String[] args) {

            Q9 q9 = new Q9();
            //q9.q12(new int[]{87,89,92,100,76});
            q9.q15();
        }
    }
}
