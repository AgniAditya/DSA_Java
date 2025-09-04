package CodeForces;

import java.util.*;

public class A_InSearchOfAnEasyProblem {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numberOfOpinions = sc.nextInt();
            while (numberOfOpinions-- > 0) {
                int opinion = sc.nextInt();
                if(opinion == 1) {
                    System.out.println("HARD");
                    return;
                }
            }
            System.out.println("EASY");
        }
    }
}
