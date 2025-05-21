// Ternary numeric notation is quite popular in Berland. To telegraph the ternary number the Borze alphabet is used. Digit 0 is transmitted as «.», 1 as «-.» and 2 as «--». You are to decode the Borze code, i.e. to find out the ternary number given its representation in Borze alphabet.

// Input
// The first line contains a number in Borze code. The length of the string is between 1 and 200 characters. It's guaranteed that the given string is a valid Borze code of some ternary number (this number can have leading zeroes).

// Output
// Output the decoded ternary number. It can have leading zeroes.

import java.util.Scanner;

public class B_Broze {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.next();

            String num = "";
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == '.'){
                    num += 0;
                }
                else if(i+1 < str.length() && ch == '-' && str.charAt(i+1) == '.'){
                    num += 1;
                    i++;
                }
                else if(i+1 < str.length() && ch == '-' && str.charAt(i+1) == '-'){
                    num += 2;
                    i++;
                }
            }
            System.out.println(num);
        }
    }
}
