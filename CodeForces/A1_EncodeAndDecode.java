import java.util.Scanner;
public class A1_EncodeAndDecode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String run = sc.next();
        if(run.equals("first")){
            encode(sc);
        }
        else{
            decode(sc);
        }
    }

    private static void encode(Scanner sc){
        int len = sc.nextInt();
        String encoded = "";
        while (len-- > 0) {
            int num = sc.nextInt();
            char ch = (char)(num + 96);
            encoded += ch;
        }
        System.out.println(encoded);
    }

    private static void decode(Scanner sc){
        String encoded = sc.next();
        System.out.println(encoded.length());
        for(int i = 0; i < encoded.length(); i++){
            char ch = encoded.charAt(i);
            int num = ch - 96;
            System.out.print(num + " ");
        }
    }
}
