import java.util.Scanner;

public class A_AliceAndBob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int len = sc.nextInt();
            int a = sc.nextInt();
            int[] marbles = new int[len];

            for(int i = 0; i < len; i++) marbles[i] = sc.nextInt();
            
            int lesser = 0;
            int greater = 0;
            int equal = 0;
            for(int i = 0; i < len; i++){
                int marble = marbles[i];
                if(marble < a)
                    lesser++;
                else if(marble == a)
                    equal++;
                else
                    greater++;
            }
            
            if(equal == len){
                System.out.println(a/2);
                continue;
            }

            if(lesser < greater){
                for(int i = 0; i < len; i++){
                    if(marbles[i] > a){
                        System.out.println((marbles[i] + a)/2);
                        break;
                    }
                }
            }
            else{
                for(int i = len - 1; i >= 0; i--){
                    if(marbles[i] < a){
                        System.out.println((marbles[i] + a)/2);
                        break;
                    }
                }
            }
        }
    }
}
