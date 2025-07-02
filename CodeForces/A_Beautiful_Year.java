// It seems like the year of 2013 came only yesterday. Do you know a curious fact? The year of 2013 is the first year after the old 1987 with only distinct digits.

// Now you are suggested to solve the following problem: given a year number, find the minimum year number which is strictly larger than the given one and has only distinct digits.

// Input
// The single line contains integer y (1000 ≤ y ≤ 9000) — the year number.

// Output
// Print a single integer — the minimum year number that is strictly larger than y and all it's digits are distinct. It is guaranteed that the answer exists.

package CodeForces;

import java.util.HashSet;
import java.util.Scanner;

public class A_Beautiful_Year {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int year = sc.nextInt();
            int res = year+1;
            
            while(!isUnique(res)){
                res++;
            }

            System.out.println(res);
        }
    }

    private static boolean isUnique(int num){
        HashSet<Integer> set = new HashSet<>();
        int n = num;
        while(n > 0){
            int rem = n % 10;
            if(set.contains(rem)) return false;
            set.add(rem);
            n = n / 10;
        }
        return true;
    }
}
