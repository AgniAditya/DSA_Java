import java.util.Arrays;
import java.util.Scanner;

public class C_MagicWind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfTestCases = sc.nextInt();
        
        while (numOfTestCases-- > 0) {
            int numOfToys = sc.nextInt();
            int[] toys = new int[numOfToys];

            for(int i = 0; i < numOfToys; i++){
                toys[i] = sc.nextInt();
            }

            sortIt(toys);
        }
    }

    private static void sortIt(int[] toys){
        boolean even = false;
        boolean odd = false;

        for(int i : toys){
            if(i % 2 == 0) even = true;
            else odd = true;
        }

        if(even && odd){
            Arrays.sort(toys);
        }
        for(int i : toys) System.out.print(i + " ");
    }
}
