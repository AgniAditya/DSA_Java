package KrapRabin;
public class Karprabin {
    private static final int PRIME = 101;
    private double calulateHash(String str){
        double hash = 0;
        for(int i = 0; i < str.length(); i++){
            hash = hash + str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }
    private double updateHash(double prevHash,char oldchar,char newChar,int patternlength){
        double newhash = (prevHash - oldchar) / PRIME;
        newhash = newhash + newChar * Math.pow(PRIME, patternlength - 1);
        return newhash;
    }

    public void search(String text,String pattern){
        int patternlength = pattern.length();
        double patternHash = calulateHash(pattern);
        double textHash = calulateHash(text.substring(0, patternlength));

        for(int i = 0; i <= text.length() - patternlength; i++){
            if(textHash == patternHash){
                if(text.substring(i, i+patternlength).equals(pattern)){
                    System.out.println("Pattern present at -> " + i);
                }
            }
            if(i < text.length() - patternlength){
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternlength), patternlength);
            }
        }
    }
}