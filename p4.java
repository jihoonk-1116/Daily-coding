import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class p4 {

    /**
     * 15
     * BACBACCACCBDEDE
     * out C
     */

    public static void q1(){
        String str = "BACBACCACCBDEDE";
        HashMap<Character, Integer> map = new HashMap<>();
        char ans=' ';
        int max = 0;
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
            if(max < map.get(c)){
                max = map.get(c);
                ans = c;
            }
        }

        for (char x : map.keySet()) {
            System.out.println(x + "  " + map.get(x));
        }

        System.out.println(ans);
    }

    /**
     * 구성이 일치하면 두 단어는 아나그램
     *  AbaAeCe baeeACA  -> t
     *  abaCC   Caaab    -> f
     */
    public static void q2(){
        String s1 = "AbaAeCe";
        String s2 = "baeeACA";

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Boolean ans = true;
        for(char c : s2.toCharArray()){
            if(map.containsKey(c) && map.get(c) != 0){
                map.put(c, map.get(c) -1);
            }
            else{
                ans = false;
                break;
            }
        }
        System.out.println("ans = " + ans);
    }

    /**
     * during 4
     * 20 12 20 10 23 17 10
     * //expand window as k-1
     * //ex) window's size is 4, then at this point, the window size is 3
     * //it's gonna be size 4 in the next loop
     * //        for(int i=0;i<k-1;i++){
     * //            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
     * //        }
     * //
     * //
     * //        int lt = 0;
     * //        for(int rt = k-1;rt<arr.length;rt++){
     * //            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
     * //            ans.add(map.size());
     * //            map.put(arr[lt],map.get(arr[lt])-1);
     * //            if(map.get(arr[lt]) == 0){
     * //                map.remove(arr[lt]);
     * //            }
     * //            lt++;
     * //        }
     */
    public static void q3(int k){

        int[] arr = {20, 12, 20, 10, 23, 17, 10};
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int lt = 0;
        for(int rt = 0;rt<arr.length;rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            //window keeps expanding as k-1
            if(rt >= k-1){
                ans.add(map.size());
                map.put(arr[lt],map.get(arr[lt])-1);
                if(map.get(arr[lt]) == 0){
                    map.remove(arr[lt]);
                }
                lt++;
            }
        }
        System.out.println(ans);
    }

    /**
     *
     * bacaAacba
     * abc
     * out - 3 {bac,acb,cba}
     *
     * bacaAacbaa
     * abca
     * out - 3
     */
    public static void q4(String s, String c){

        HashMap<Character, Integer> compMap = new HashMap<>();
        HashMap<Character, Integer> subMap = new HashMap<>();

        for(char ch : c.toCharArray()){
            compMap.put(ch, compMap.getOrDefault(ch,0) + 1);
        }

        int lt = 0, ans = 0;
        for(int rt=0;rt<s.length();rt++){
            subMap.put(s.charAt(rt), subMap.getOrDefault(s.charAt(rt), 0) + 1);
            if(rt >= c.length() - 1){
                if(compMap.equals(subMap)){
                    ans++;
                }
                subMap.put(s.charAt(lt), subMap.get(s.charAt(lt)) - 1);
                if(subMap.get(s.charAt(lt))==0){
                    subMap.remove(s.charAt(lt));
                }
                lt++;
            }
        }
        System.out.println("ans = " + ans);
    }

    //TreeSet -> remove duplicated value and sorting

    /**
     * 10 3
     * 13 15 34 23 45 65 33 11 26 42
     * out - 143
     */
    public static void q5(int [] arr, int pos){
        int ans = 0;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder()); //descending sorted order
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    treeSet.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }
        int cnt = 0;
        treeSet.remove(143);
        System.out.println(treeSet.first());
        System.out.println(treeSet.higher(143));
        System.out.println(treeSet.last());
        for (Integer integer : treeSet) {
            cnt++;
            if(cnt == pos)
                System.out.println(integer);
        }

    }


    public static void main(String[] args) {
        //q4("bacaAacba", "abc");
        q5(new int[] {13, 15, 34, 23, 45, 65, 33, 11, 26, 42}, 3);
    }
}
