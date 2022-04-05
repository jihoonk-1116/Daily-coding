public class Coding {
    public static void main(String[] args) {
        String s = "CompUtEr.com";
        String target = "c";
        getAnswer2(s, target);


    }
    public static void getAnswer2(String s, String t){
        String answer = "";
//        for(char c : s.toCharArray()){
//            if(Character.isUpperCase(c)){
//                c = Character.toLowerCase(c);
//            }else{
//                c = Character.toUpperCase(c);
//            }
//            answer += c;
//        }
        for(char c : s.toCharArray()){
            if(c=='.') {
                answer += c;
                continue;
            }
            if(c >= 97 && c <= 122){  //Lower case range from 97 ~ 122
                answer += (char)(c-32);
            }else{                  // Upper case range from 65 ~ 90
                answer += (char)(c+32);
            }
        }
        System.out.println("s = " + answer);
    }



    public static void getAnswer(String sentence, String target){

        sentence = sentence.toUpperCase();
        target = target.toUpperCase();

        int count = 0;
//        for(int i=0;i<sentence.length();i++){
//            if(sentence.charAt(i) == target.charAt(0)){
//                count++;
//            }
//        }

        for(char c : sentence.toCharArray()){
            if(c == target.charAt(0)) count++;
        }

        System.out.println("count = " + count);

    }
}
