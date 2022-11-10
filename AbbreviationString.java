//BAT
//"BAT", "BA1", "B1T", "B2", "1AT", "1A1", "2T", "3"

class AbbreviationString{
  
  public static void main(String[] args){
        List<String> res = new ArrayList<>();
        abbreviationString("BAT", new StringBuilder(), 0, 0, res);
        System.out.println(res);
  }
  
  
  private static void abbreviationString(String w, StringBuilder sb, int s, int c, List<String> res){
        if(s == w.length()){
            if(c != 0) sb.append(c);
            res.add(sb.toString());
            return;
        }
        abbreviationString(w, sb, s+1, c+1, res);
        sb.deleteCharAt(sb.length()-1);
        if(c != 0) sb.append(c);
        sb.append(w.charAt(s));
        abbreviationString(w, sb, s+1, 0, res);
        sb.deleteCharAt(sb.length()-1);
    }
}

