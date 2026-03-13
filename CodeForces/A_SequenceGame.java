import java.util.Scanner;

public class A_SequenceGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int n = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < n; i++){
                int val = sc.nextInt();
                max = Math.max(max, val);
                min = Math.min(min, val);
            }

            int x = sc.nextInt();
            if(x >= min && x <= max) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
