package Recursion;
import java.util.ArrayList;

public class PermutaionRec {
    public static void main(String[] args) {
        ArrayList<String> ans = permutaionlist("", "abc");
        System.out.println(ans);
        System.out.println(permutaioncount("", "abc"));
    }

    static void permutaion(String p , String s){
        if(s.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = s.charAt(0);
        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permutaion(first+ch+second, s.substring(1));
        }
    }

    static ArrayList<String> permutaionlist(String p , String s){
        if(s.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch = s.charAt(0);
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            res.addAll((permutaionlist(first+ch+second, s.substring(1))));
        }
        return res;
    }

    static int permutaioncount(String p , String s){
        if(s.isEmpty()){
            return  1;
        }
        char ch = s.charAt(0);
        int cnt = 0;
        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            cnt += permutaioncount(first+ch+second, s.substring(1));
        }
        return cnt;

        // return permutaionlist(p, s).size();
    }
}