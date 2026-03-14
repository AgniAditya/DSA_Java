import java.util.*;

public class A_ErasingZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int i = 0;
            while (i < s.length() && s.charAt(i) == '0') {
                i++;
            }
            int j = s.length() - 1;
            while (j >= 0 && s.charAt(j) == '0') {
                j--;
            }
            int zeros = 0;
            for(int k = i; k <= j; k++) if(s.charAt(k) == '0') zeros++;
            System.out.println(zeros);
        }
    }
}
