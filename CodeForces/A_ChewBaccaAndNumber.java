import java.util.*;

public class A_ChewBaccaAndNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long ans = 0;
        long x = 1;
        while (num > 0) {
            long rem = num % 10;
            num = num/10;
            long n = Math.min(rem,9-rem);
            if(rem == 9 && num == 0) n = 9;
            ans = ans + x * n;
            x = x * 10;
        }
        System.out.println(ans);
    }
}
