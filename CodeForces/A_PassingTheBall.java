import java.util.*;

public class A_PassingTheBall {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int[] visited = new int[n];
            Arrays.fill(visited,-1);
            int i = 0;
            int times = 0;
            while (times < n && visited[i] == -1) {
                visited[i] = 1;
                char ch = s.charAt(i);
                if(ch == 'R') i = i + 1;
                else if(ch == 'L') i = i - 1;
                times++;
            }
            System.out.println(times);
        }
    }
}