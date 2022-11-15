public class DecodeMorse {
    public static void main(String[] args) {
        String[] code =
                { ".-",   "-...", "-.-.", "-..",  ".",
                "..-.", "--.",  "....", "..",   ".---",
                "-.-",  ".-..", "--",   "-.",   "---",
                ".--.", "--.-", ".-.",  "...",  "-",
                "..-",  "...-", ".--",  "-..-", "-.--",
                "--.." };

        HashMap<String, Character> morseMap = new HashMap<>();
        populateMap(morseMap, code);
        String res = decodeMorse("... -.-. .... --- --- .-..", morseMap);
        System.out.println(res);
    }

    private static void populateMap(HashMap<String, Character> map, String[] morses){
        for(int i=0;i<26;i++){
            char alpha = (char)('a' + i);
            map.put(morses[i], alpha);
        }
    }

    private static String decodeMorse(String input, HashMap<String, Character> map){
        String [] signals = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String signal : signals){
            sb.append(map.get(signal));
        }
        return sb.toString();
    }
}
