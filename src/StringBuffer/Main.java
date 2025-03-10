public class Main {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("Google");
        sb.replace(0, 1, "A");

        String str = sb.toString();
        System.out.println(str);
    }
}