import java.util.*;

public class A_SolidersAndBanana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();

        int i = 1;

        while (i <= w && i*k <= n) {
            n -= i * k;
            i++;
        }
        
        int ans = i*k - n;
        if(i > w){
            ans = 0;
        }
        i++;
        while (i <= w) {
            ans += i*k;
            i++;
        }
        System.out.println(ans);
    }
}
