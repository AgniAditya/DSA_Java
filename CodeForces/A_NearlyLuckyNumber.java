import java.util.*;

public class A_NearlyLuckyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long count = 0;
        while (num > 0) {
            long n = num % 10;
            if(n == 4 || n == 7) count++;
            num = num/10;
        }
        System.out.println(count == 7 || count == 4 ? "YES" : "NO");
    }
}