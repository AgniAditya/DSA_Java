import java.util.*;

public class A_SimonsMakeItBeautiful {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

            int[] max = new int[n];
            max[0] = 0;
            for(int i = 1; i < n; i++){
                int prev = arr[max[i-1]];
                int curr = arr[i];
                if(prev > curr){
                    max[i] = max[i-1];
                }else {
                    max[i] = i;
                }
            }

            int ugly1 = -1;
            int ugly2 = -1;
            for(int i = 0; i < n; i++){
                if(i+1 == arr[max[i]]){
                    if(ugly1 == -1) ugly1 = max[i];
                    else ugly2 = max[i];
                }
            }

            if(ugly1 != -1 && ugly2 != -1){
                int temp = arr[ugly1];
                arr[ugly1] = arr[ugly2];
                arr[ugly2] = temp;
            }

            for(int i = 0; i < n; i++) System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}
