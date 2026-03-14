import java.util.*;

public class A_GennadyAndCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tableCard = sc.next();
        String[] cards = new String[5];
        for(int i = 0; i < 5; i++) cards[i] = sc.next();
        for(int i = 0; i < 5; i++){
            String card = cards[i];
            if(card.charAt(0) == tableCard.charAt(0) || card.charAt(1) == tableCard.charAt(1)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
