import java.util.*;

public class A_WrongSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int k = sc.nextInt();
        while (k-- > 0) {
            if(number % 10 == 0) number /= 10;
            else number--;
        }
        System.out.println(number);
    }
}
