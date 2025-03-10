public class stringLinearSearch {
    public static boolean searchStringchar(String s,char c){
        if(s.length()==0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        String s="Aditya";
        char c='o';
        System.out.println(searchStringchar(s, c));
        System.out.println(searchStringchar(s, 'a'));
    }
}
