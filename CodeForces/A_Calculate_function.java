// For a positive integer n let's define a function f:

// f(n) =  - 1 + 2 - 3 + .. + ( - 1)nn

// Your task is to calculate f(n) for a given integer n.

// Input
// The single line contains the positive integer n (1 ≤ n ≤ 1015).

// Output
// Print f(n) in a single line.

package CodeForces;
import java.util.Scanner;

public class A_Calculate_function {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long num = sc.nextLong();
        long no_odd = num - (num/2);

        if(num % 2 == 0) System.out.println(no_odd);
        else System.out.println(-no_odd);

        sc.close();
    }
}