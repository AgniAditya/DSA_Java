import java.util.*;

public class A_ArrivalOfTheGeneral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int min = n-1;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] <= arr[min]) min = i;
            if(arr[i] > arr[max]) max = i;
        }
        int ans = max + (n - 1 - min);
        if(max > min) ans = ans - 1;
        System.out.println(ans);
    }
}
