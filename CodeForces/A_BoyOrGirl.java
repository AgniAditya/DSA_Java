import java.util.HashSet;
import java.util.Scanner;

public class A_BoyOrGirl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < userName.length(); i++) {
            set.add(userName.charAt(i));
        }
        if(set.size() % 2 == 0) System.out.println("CHAT WITH HER!");
        else System.out.println("IGNORE HIM!");
    }
}
