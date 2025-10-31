import java.util.*;

public class A_Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfProblems = sc.nextInt();
        int solvedProblems = 0;
        while (numOfProblems-- > 0) {
            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += sc.nextInt();
            }
            if(sum >= 2) solvedProblems++;
        }
        System.out.println(solvedProblems);
    }
}
