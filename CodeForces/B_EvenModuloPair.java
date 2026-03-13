import java.util.Scanner;
public class B_EvenModuloPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

            int x = -1;
            int y = -1;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    if( (arr[j] % arr[i]) % 2 == 0){
                        x = arr[i];
                        y = arr[j];
                        break;
                    }
                }
            }

            if(x != -1 && y != -1) System.out.println(x + " " + y);
            else System.out.println(x);
        }
    }
}
