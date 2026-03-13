import java.util.*;

public class A_EatingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int max = 0;
            int count = 0;
            for(int i = 0; i < n; i++) nums[i] = sc.nextInt();
            for(int i = 0; i < n; i++) max = Math.max(max, nums[i]);
            for(int i = 0; i < n; i++) if(nums[i] == max) count++;
            System.out.println(count);
        }
    }
}