import java.util.Scanner;

public class A_Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            boolean canMakeIt = true;
            int length = sc.nextInt();
            for(int i = 0; i < 3; i++){
                int curr = sc.nextInt();
                if(length != curr) {
                    canMakeIt = false;
                }
            }
            if(canMakeIt) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
