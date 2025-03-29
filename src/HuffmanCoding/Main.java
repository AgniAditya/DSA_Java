package HuffmanCoding;
public class Main {
    public static void main(String[] args) throws Exception{
        String str = "Oye sun";
        HuffmanCoding hf = new HuffmanCoding(str);
        String cs = hf.encodeString(str);
        System.out.println(cs);
        String dc = hf.decodeString(cs);
        System.out.println(dc);
    }
}
