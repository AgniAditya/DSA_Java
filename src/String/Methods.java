package String;
import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        String name="   fly me   to   the moon  ";
        String a=name.strip();
        String[] b=a.split(" ");
        System.out.println(Arrays.toString(b));
        System.out.println(b[b.length-1].length());
        System.out.println(Arrays.toString(name.toCharArray()));
        // System.out.println(name.length());
        // System.out.println(name);
        // System.out.println(name.indexOf('a'));
        // System.out.println("    Aditya    ".strip());
        System.out.println(Arrays.toString(name.split(" ")));
    }
}