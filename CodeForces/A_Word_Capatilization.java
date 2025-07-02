// Capitalization is writing a word with its first letter as a capital letter. Your task is to capitalize the given word.

// Note, that during capitalization all the letters except the first one remains unchanged.

// Input
// A single line contains a non-empty word. This word consists of lowercase and uppercase English letters. The length of the word will not exceed 103.

// Output
// Output the given word after capitalization.

// package CodeForces;

import java.util.Scanner;

public class A_Word_Capatilization {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String word = sc.nextLine();
            if(isLowerCase(word.charAt(0))) System.out.println(toUpperCase(word.charAt(0)) + word.substring(1));
            else System.out.println(word);
        }
    }

    private static char toUpperCase(char ch){
        return (char)((int)ch - 32);
    }

    private static boolean isLowerCase(char ch){
        return (int)ch >= 97 && (int)ch <= 122;
    }
}
