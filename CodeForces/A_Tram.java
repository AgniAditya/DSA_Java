import java.util.*;

public class A_Tram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = 0;
        int total = 0;
        for(int i = 0; i < n; i++){
            int exit = sc.nextInt();
            int enter = sc.nextInt();
            total = total - exit;
            total = total + enter;
            min = Math.max(total, min);
        }
        System.out.println(min);
    }
}