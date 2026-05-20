package CSES;
public class DeepRecursion {
    public static void main(String[] args) {
        try{
            recursive();
        } catch (StackOverflowError e){
            System.out.println(depth);
        }
    }

    static int depth = 0;
    private static void recursive(){
        depth++;
        recursive();
    }
}