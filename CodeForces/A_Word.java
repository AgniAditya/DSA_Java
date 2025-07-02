// Vasya is very upset that many people on the Net mix uppercase and lowercase letters in one word. That's why he decided to invent an extension for his favorite browser that would change the letters' register in every word so that it either only consisted of lowercase letters or, vice versa, only of uppercase ones. At that as little as possible letters should be changed in the word. For example, the word HoUse must be replaced with house, and the word ViP — with VIP. If a word contains an equal number of uppercase and lowercase letters, you should replace all the letters with lowercase ones. For example, maTRIx should be replaced by matrix. Your task is to use the given method on one given word.

// Input
// The first line contains a word s — it consists of uppercase and lowercase Latin letters and possesses the length from 1 to 100.

// Output
// Print the corrected word s. If the given word s has strictly more uppercase letters, make the word written in the uppercase register, otherwise - in the lowercase one.

// package CodeForces;

import java.util.Scanner;

public class A_Word {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String s = sc.nextLine();
            int upper = 0;
            int lower = 0;
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(isUpperCase(ch)) upper++;
                else lower++;
            }

            if(upper > lower) System.out.print(toUpperCase(s));
            else System.out.println(toLowerCase(s));
        }
    }

    private static boolean isUpperCase(char ch){
        return (int)ch >= 65 && (int)ch <= 90;
    }

    private static String toUpperCase(String s){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!isUpperCase(ch)) str.append((char)((int)ch - 32));
            else str.append(ch);
        }
        return str.toString();
    }

    private static String toLowerCase(String s){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(isUpperCase(ch)) str.append((char)((int)ch + 32));
            else str.append(ch);
        }
        return str.toString();
    }
}
