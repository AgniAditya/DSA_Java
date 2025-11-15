import java.util.*;

public class A_NextRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        int[] contestents = new int[len];

        for(int i = 0; i < len; i++) contestents[i] = sc.nextInt();

        int qualifyContestent = 0;
        if(contestents[k-1] == 0){
            for(int i = k - 1; i >= 0; i--){
                if(contestents[i] > 0) qualifyContestent++;
            }
        }
        else{
            qualifyContestent += k;
            for(int i = k; i < len; i++){
                if(contestents[i] == contestents[k-1]) qualifyContestent++;
            }
        }
        System.out.println(qualifyContestent);
    }
}
