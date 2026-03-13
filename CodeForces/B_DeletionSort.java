import java.util.Scanner;

public class B_DeletionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) nums[i] = sc.nextInt();
            boolean isNonDecreasing = false;
            for(int i = 1; i < n; i++) if(nums[i] < nums[i-1]) isNonDecreasing = true;
            if(isNonDecreasing) System.out.println(1);
            else System.out.println(n);
        }
    }
}
