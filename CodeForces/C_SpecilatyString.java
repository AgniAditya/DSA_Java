import java.util.*;

public class C_SpecilatyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                if(!stack.isEmpty() && stack.peek() == s.charAt(i)) stack.pop();
                else stack.add(s.charAt(i));
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
