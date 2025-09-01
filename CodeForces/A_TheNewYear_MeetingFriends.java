package CodeForces;

import java.util.Scanner;

public class A_TheNewYear_MeetingFriends {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            System.out.println(Math.max(x,Math.max(y, z)) - Math.min(x,Math.min(y, z)));
        }
    }
}
