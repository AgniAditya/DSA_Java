import java.util.Scanner;

public class C_Spring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long m = sc.nextLong();

            long A = m/a;
            long B = m/b;
            long C = m/c;

            long ab = lcm(a,b);
            long bc = lcm(b,c);
            long ac = lcm(a, c);
            long abc = lcm(ab, c);

            long AB = m/ab;
            long BC = m/bc;
            long AC = m/ac;
            long ABC = m/abc;

            long onlyA = A - AB - AC + ABC;
            long onlyB = B - AB - BC + ABC;
            long onlyC = C - AC - BC + ABC;

            long onlyAB = AB - ABC;
            long onlyBC = BC - ABC;
            long onlyAC = AC - ABC;

            long alice = 6*onlyA + 3*onlyAB + 3*onlyAC + 2*ABC;
            long bob = 6*onlyB + 3*onlyAB + 3*onlyBC + 2*ABC;
            long carol = 6*onlyC + 3*onlyAC + 3*onlyBC + 2*ABC;

            System.out.println(alice + " " + bob + " " + carol);
        }
    }
    static long gcd(long a,long b){
        return b==0 ? a : gcd(b,a%b);
    }

    static long lcm(long a,long b){
        return a/gcd(a,b)*b;
    }
}
