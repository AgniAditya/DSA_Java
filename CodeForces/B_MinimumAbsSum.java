import java.util.ArrayList;
import java.util.Scanner;

public class B_MinimumAbsSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            boolean[] edge = new boolean[2];
            int[] a = new int[n];
            for(int i = 0; i < n; i++) a[i] = sc.nextInt();
            if(a[0] == -1) edge[0] = true;
            if(a[n-1] == -1) edge[1] = true;
            for(int i = 0; i < n; i++) a[i] = a[i] != -1 ? a[i] : 0;
            
            int[] b = new int[n-1];
            for(int i = 0; i < n - 1; i++) b[i] = a[i+1] - a[i];

            int pos = 0;
            int neg = 0;
            for(int i : b){
                if(i < 0) neg += i;
                else pos += i;
            }

            int sum = pos + neg;
            if(edge[0] && sum > 0) 
        }
    }
}