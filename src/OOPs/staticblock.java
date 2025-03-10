public class staticblock {
    static int a = 3;
    static int b;

    // Will only run once when the first obj is made i.e when the class is loaded for the first time.
    static{
        System.out.println("Static section");
        b = a * 5;
    }

    public static void main(String[] args) {
        staticblock obj = new staticblock();
        System.out.println(staticblock.a + staticblock.b);
        staticblock.b = 5;
        staticblock obj2 = new staticblock();
        System.out.println(staticblock.a + staticblock.b);
    }
}
