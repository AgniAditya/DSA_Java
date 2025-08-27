import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class A_Footbal {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            Map<String, Integer> teams = new HashMap<>();
            while (n-- > 0) {
                String team = sc.next();
                teams.put(team, teams.getOrDefault(team, 0) + 1);
            }
            int maxCount = 0;
            String winner = "";
            for (Map.Entry<String, Integer> entry : teams.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    winner = entry.getKey();
                }
            }

            System.out.println(winner);
        }
    }
}