public class RandomString {
    static String generate(int size){
        StringBuffer str = new StringBuffer();
        int min = 32;
        int max = 126;
        for(int i = 0; i < size; i++){
            int randomnum = min + (int)(Math.random() * ((max - min) + 1));
            char ch = (char)randomnum;
            str.append(ch); 
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(generate(10));
    }
}
