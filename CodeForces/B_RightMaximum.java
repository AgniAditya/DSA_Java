import java.util.*;

public class B_RightMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) nums[i] = sc.nextInt();
            System.out.println(rightMax(n,nums));
        }
    }
    
    static int rightMax(int n,int[] nums){
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
            (a,b) -> (b[1] != a[1]) ? b[1]-a[1] : b[0]-a[0]
        );
        for(int j = n-1; j >= 0; j--) maxpq.add(new int[] {j,nums[j]}); 
        int i = n - 1;
        int opr = 0;
        while (i >= 0) {
            while (!maxpq.isEmpty() && maxpq.peek()[0] > i) {
                maxpq.poll();
            }
            int max = maxpq.poll()[0];
            opr++;
            i = max - 1;
        }
        return opr;
    }
}