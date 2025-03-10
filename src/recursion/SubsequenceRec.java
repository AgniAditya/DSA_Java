package Recursion;
import java.util.ArrayList;

public class SubsequenceRec {
    public static void main(String[] args) {
        String str = "abc";
        // ArrayList<String> res = new ArrayList<String>();
        System.out.println(subseqlist("", str));
    }

    static void subseq(String p , String s){
        if(s.isEmpty()){
            System.out.println(p);
            return;
        }
        subseq(p + s.charAt(0), s.substring(1));
        subseq(p, s.substring(1));
    }

    static void subseq(String p, String s, ArrayList<String> res){
        if(s.isEmpty()){
            res.add(p);
            return;
        }
        subseq(p + s.charAt(0), s.substring(1),res);
        subseq(p, s.substring(1),res);
    }

    static ArrayList<String> subseqlist(String p, String s){
        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = subseqlist(p + s.charAt(0), s.substring(1));
        ArrayList<String> right = subseqlist(p, s.substring(1));
        
        left.addAll(right);
        return left;
    }
}