import java.util.Scanner;

public class A_FarmLegs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            if(n % 2 != 0) {
                System.out.println(0); 
                continue;
            }
            int i = 2;
            int val = 1;
            while (i <= n) {
                if(i % 2 == 0 && i % 4 == 0) val++;
                i += 2;
            }
            System.out.println(val);
        }
    }
}
