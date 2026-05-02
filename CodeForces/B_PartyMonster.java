import java.util.Scanner;

public class B_PartyMonster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ob = 0;
            int cb = 0;
            String s = sc.next();
            for(int i = 0; i < n; i++){
                char ch = s.charAt(i);
                if(ch == '(') ob++;
                else cb++;
            }
            if(ob == cb) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
