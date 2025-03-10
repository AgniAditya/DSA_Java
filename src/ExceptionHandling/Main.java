public class Main {
    public static void main(String[] args) {
        try{
            int a = 5;
            int b = 0;
            if(b==0){
                throw new customExceptions("Invalid");
            }
            System.out.println((double)a/b);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Executed");
        }
    }
}