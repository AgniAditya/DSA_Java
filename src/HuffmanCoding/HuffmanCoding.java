package HuffmanCoding;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int freq;
        Node left;
        Node right;
        
        public Node (Character data,int freq){
            this.data = data;
            this.freq = freq;
        }

        @Override
        public int compareTo(Node other){
            return this.freq - other.freq;
        }
    }

    public HuffmanCoding(String feeder) throws Exception{
        HashMap<Character,Integer> freqHashMap = new HashMap<>();

        for(int i = 0; i < feeder.length(); i++){
            freqHashMap.put(feeder.charAt(i),freqHashMap.getOrDefault(freqHashMap, 0) + 1);
        }

        PriorityQueue<Node> minheap = new PriorityQueue<>();

        for(Map.Entry<Character,Integer> entry : freqHashMap.entrySet()){
            Node node = new Node(entry.getKey(), entry.getValue());
            minheap.add(node);
        }

        while (minheap.size()  != 1) {
            Node right = minheap.poll();
            Node left = minheap.poll();

            int newfreq = left.freq + right.freq;
            Node newNode = new Node('\0',newfreq);
            newNode.left = left;
            newNode.right = right;

            minheap.add(newNode);
        }

        Node ft = minheap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(ft,"");
    }

    private void initEncoderDecoder(Node node,String bits){

        if(node.right == null && node.left == null){
            this.encoder.put(node.data,bits);
            this.decoder.put(bits,node.data);
            return;
        }
        initEncoderDecoder(node.left,bits+'0');
        initEncoderDecoder(node.right,bits+'1');
    }

    public String encodeString(String source){
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < source.length(); i++){
            ans.append(encoder.get(source.charAt(i)));
        }

        return ans.toString();
    }

    public String decodeString(String source){
        StringBuilder ans = new StringBuilder();

        String key = "";        
        for(int i = 0; i < source.length(); i++){
            key += source.charAt(i);
            if(decoder.containsKey(key)){
                ans.append(decoder.get(key));
                key = "";
            }
        }

        return ans.toString();
    }
}