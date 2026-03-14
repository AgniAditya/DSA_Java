import java.util.*;
public class A_RepeatingCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String ans = "";
        int len = 1;
        int i = 0;
        while (i < n) {
            int steps = len + i;
            while (i < steps) {
                i++;
            }
            ans += s.charAt(i-1);
            len = len + 1;
        }
        System.out.println(ans);
    }
}
