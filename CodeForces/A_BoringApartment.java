import java.util.*;
public class A_BoringApartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int num = sc.nextInt();
            int rem = num % 10;
            int ans = 10 * (rem - 1);
            int len = 0;
            while (num > 0) {
                num = num / 10;
                len++;
            }
            if(len == 1) System.out.println(ans + 1);
            else if(len == 2) System.out.println(ans + 3);
            else if(len == 3) System.out.println(ans + 6);
            else System.out.println(ans + 10);
        }
    }
}
