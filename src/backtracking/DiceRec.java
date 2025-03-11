package backtracking;
import java.util.ArrayList;
public class DiceRec {
    public static void main(String[] args) {
        comofdice("", 4);
        System.out.println(comofdicearr("", 4));
    }
    static void comofdice(String p,int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=target;i++){
            comofdice(p+i, target-i);
        }
    }
    static ArrayList<String> comofdicearr(String p,int target){
        if(target == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> res = new ArrayList<>();
        for(int i=1;i<=target;i++){
            res.addAll(comofdicearr(p+i, target-i));
        }
        return res;
    }
}