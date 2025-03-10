public class Innerclasses {
    static class Testclass {
        String name;
        public Testclass(String name){
            System.out.println(name);
        }
    }
    public static void main(String[] args){
        Testclass obj1 = new Testclass("Aditya");
    }
}
