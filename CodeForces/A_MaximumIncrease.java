import java.util.*;

public class A_MaximumIncrease {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = sc.nextInt();
        System.out.println(maximumlengthsubarray(n, nums));
    }

    private static int maximumlengthsubarray(int n,int[] nums){
        int max = 0;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] > nums[j-1]) {
                j++;
            }
            max = Math.max(max, j - i);
            i = j;
        }
        return max;
    }
}
