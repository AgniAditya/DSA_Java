package String;
public class palindromeString {
    public static void main(String[] args) {
        String name="Aditya";
        System.out.println(Palindrome(name));
        System.out.println(Palindrome("Refer"));
    }

    static String Palindrome(String s){
        if(s==null){
            return "Palindrome";
        }
        s=s.toLowerCase();
        int end=s.length()-1;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(end)){
                return "Not a Palindrome";
            }
            end--;
        }
        return "Palindrome";
    }
}