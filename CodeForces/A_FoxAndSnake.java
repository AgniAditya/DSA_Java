import java.util.*;
public class A_FoxAndSnake {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int row = sc.nextInt();
            int col = sc.nextInt();
            String oddrows = "";
            String evenrows = "";
            boolean atLastorFirst = false;

            for(int i = 1; i <= col; i++) oddrows += '#';
            for(int i = 1; i <= col - 1; i++) evenrows += '.';
            
            for(int i = 1; i <= row; i++){
                if(i % 2 == 0){
                    if(atLastorFirst) System.out.println('#'+evenrows);
                    else System.out.println(evenrows+'#');
                    atLastorFirst = !atLastorFirst;
                }
                else{
                    System.out.println(oddrows);
                }
            }
        }
    }
}
