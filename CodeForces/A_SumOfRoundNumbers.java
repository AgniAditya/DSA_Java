package CodeForces;
import java.util.ArrayList;
import java.util.Scanner;

public class A_SumOfRoundNumbers {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfTestCases = sc.nextInt();

            while (numOfTestCases-- > 0) {
                ArrayList<Integer> roundedNumbers = new ArrayList<>();
                int number = sc.nextInt();
                int place = 1;
                while (number > 0) {
                    int rem = number % 10;
                    if(rem != 0) roundedNumbers.add(rem * place);
                    number /= 10;
                    place *= 10;
                }
                
                System.out.println(roundedNumbers.size());
                for(int i : roundedNumbers) System.out.print(i + " ");
                System.out.println();
            }
        }
    }
}
