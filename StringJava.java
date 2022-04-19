import java.util.ArrayList;
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

            while ((pos = s.indexOf(' ')) != -1) {

                String tmp = s.substring(0, pos);
                if (ans.length() < tmp.length()) {
                    ans = tmp;
                }
                s = s.substring(pos + 1);
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

        private String[] strArr = { "hi", "jihoon", "great", "sam" };

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

    public static void main(String[] args) {

        Q7 q7 = new Q7();
        q7.q7_call();
    }
}
