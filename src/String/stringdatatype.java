package String;
import java.util.ArrayList;

public class stringdatatype {
    public static void main(String[] args) {
        //String are immutuable.

        //Here a and b both are reference variable.
        //That is why it is giving true.
        // String a ="Aditya";
        // String b="Aditya";
        // System.out.println(a==b);
        // System.out.println(a.equals(b));
        // System.out.println(a.charAt(0));

        //Here a1 and a2 are both different objects.
        //That is why it is giving false as a result.
        // String a1=new String("Agni");
        // String a2=new String("Agni");
        // System.out.println(a1==a2);
        // System.out.println(a1.equals(a2));

        // int a=10;
        // System.out.println(Integer.toString(a)+10);

        // int a=453;
        // float b=a;
        // System.out.printf("Formatted number is %.5f",b);

        System.out.println('a'+'b');
        System.out.println("a" + "b");
        System.out.println('a'+ 1);
        System.out.println((char)('a'+ 1));
        System.out.println("a" + 1);

        System.out.println("Aditya" + new ArrayList<>());
        System.out.println("Aditya" + 56);
        System.out.println(0 + "" + new ArrayList<>());
    }
}