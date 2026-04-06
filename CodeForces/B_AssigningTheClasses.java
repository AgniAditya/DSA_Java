import java.util.Arrays;
import java.util.Scanner;

public class B_AssigningTheClasses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[2*n];
            for(int i = 0; i < 2*n; i++){
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(Math.abs(nums[n] - nums[n-1]));
        }
    }
}