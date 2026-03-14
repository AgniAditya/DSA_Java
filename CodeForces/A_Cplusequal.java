import java.util.*;

public class A_Cplusequal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
           int a = sc.nextInt();
           int b = sc.nextInt();
           int n = sc.nextInt();
           int a_prev = a;
           int b_prev = b;
           int opr = 0;
           while (a <= n && b <= n) {
            a += b_prev;
            b += a_prev;
            a_prev = a;
            b_prev = b;
            opr++;
           }
           System.out.println(opr);
        }
    }
}
