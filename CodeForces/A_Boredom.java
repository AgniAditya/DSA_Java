import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A_Boredom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while(i < n){
            int cnt = 0;
            int j = i;
            while(j < n && nums[j] == nums[i]){
                cnt++;
                j++;
            }
            list.add(new int[] {nums[i],cnt});
            i = j;
        }

        int[] dp = new int[list.size() + 1];
        dp[0] = 0;
        dp[1] = list.get(0)[0] * list.get(0)[1];
        for(int k = 2; k < dp.length; k++){
            int[] val = list.get(k-1);
            if(val[0] != list.get(k-2)[0] + 1){
                dp[k] = Math.max(dp[k-1],dp[k-2] + val[0] * val[1]);
            }
            else{
                dp[k] = dp[k-1] + val[0] * val[1];
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
