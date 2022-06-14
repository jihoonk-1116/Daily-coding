public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        //iterate strs
        //cumulate string elements to a string
        //with delimeter and len
        String res = "";
        for(String s : strs){
            res += "*" + s;
        }
        return res;
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int nextPos = str.indexOf("*", 1);
        
        while(nextPos != -1){
            String tempStr = str.substring(1, nextPos);
            res.add(tempStr);
            str = str.substring(nextPos);
            nextPos = str.indexOf("*", 1);
        }
        res.add(str.substring(1));
        return res;
    }
}
