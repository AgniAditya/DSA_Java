package Recursion;
public class skipAcharRec {
    public static void main(String[] args) {
        String b = "bacapplehasdaacrahq";
        System.out.println(skipchars(b,"apple"));
    }

    static String skip(String p,String s){
        if(s.isEmpty()){
            return p;
        }

        char ch = s.charAt(0);
        if(ch != 'a'){
            p += ch;
            return skip(s.substring(1));
        }else{
            return skip(s.substring(1));
        }
    }

    static String skip(String s){
        if(s.isEmpty()){
            return "";
        }
        char ch = s.charAt(0);
        if(ch != 'a'){
            return ch + skip(s.substring(1));
        }else{
            return skip(s.substring(1));
        }
    }

    static String skipchars(String s,String remove){
        if(s.isEmpty()){
            return "";
        }

        char ch = s.charAt(0);
        if(!s.startsWith(remove)){
            return ch + skipchars(s.substring(1),remove);
        }else{
            return skipchars(s.substring(remove.length()),remove);
        }
    }
}