import java.util.Scanner;
import java.util.ArrayList;

public class StringMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Text String: ");
        String text = sc.next();
        System.out.print("Enter your pattern String: ");
        String pattern = sc.next();

        System.out.println(KMP(text,pattern));
    }

    private static ArrayList<Integer> KMP(String text, String pat){
        int m = text.length();
        int n = pat.length();

        int[] lps = new int[n];
        ArrayList<Integer> res = new ArrayList<>();

        buildlps(lps,pat);

        int i = 0;
        int j = 0;
        while (i < m) {
            if(pat.charAt(j) == text.charAt(i)){
                i++;
                j++;
                if(j == n){
                    res.add(i-j);
                    j = lps[j-1];
                }
            }
            else{
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return res;
    }

    private static void buildlps(int[] lps,String pat){
        int len = 0;
        lps[0] = 0;
        int i = 1;

        while (i < pat.length()) {
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
