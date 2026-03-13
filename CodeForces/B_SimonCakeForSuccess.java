import java.util.*;

public class B_SimonCakeForSuccess {
    public static long solve(long n) {
        long k = 1;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                k *= i;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) {
            k *= n;
        }

        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            System.out.println(solve(n));
        }

        sc.close();
    }
}
