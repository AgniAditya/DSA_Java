import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B_YourName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTestCases = sc.nextInt();
        while (numOfTestCases-- > 0) {
            int size = sc.nextInt();
            String s = sc.next();
            String t = sc.next();
            Map<Character,Integer> map_s = new HashMap<>();
            Map<Character,Integer> map_t = new HashMap<>();

            for(int i = 0; i < size; i++){
                char char_s = s.charAt(i);
                map_s.put(char_s, map_s.getOrDefault(char_s, 0) + 1);
                char char_t = t.charAt(i);
                map_t.put(char_t, map_t.getOrDefault(char_t, 0) + 1);
            }

            boolean canArrangeIt = true;
            for(Map.Entry<Character,Integer> entry : map_s.entrySet()){
                char ch = entry.getKey();
                int freq = entry.getValue();
                if(!map_t.containsKey(ch) || map_t.get(ch) != freq){
                    canArrangeIt = false;
                    break;
                }
            }
            if(canArrangeIt) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
