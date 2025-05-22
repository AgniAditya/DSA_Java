package src.Graphs;
import java.util.Scanner;

public class Implementation_Trie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number of Operations -> ");
        int numOfOperations = sc.nextInt();

        Trie trie = new Trie();

        while (numOfOperations-- > 0) {
            System.out.print("For insertion press 1 or ");
            System.out.print("For searching press 2 or ");
            System.out.println("For prefix searching press 3");
            System.out.print("Enter the operation number -> ");

            int opr = sc.nextInt();

            System.out.print("Enter the Word -> ");
            String word = sc.next();

            if (opr == 1) {
                trie.insert(word);
            }
            else if(opr == 2){
                System.out.println(trie.search(word));
            }
            else if(opr == 3){
                System.out.println(trie.startsWith(word));
            }
        }

        System.out.println("Ended");
    }
}

class Trie {

    private static Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsChar(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsChar(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0; i < prefix.length(); i++){
            if(!node.containsChar(prefix.charAt(i))) return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

class Node {
    Node[] links;
    boolean endFlag;

    Node(){
        links = new Node[26];
        endFlag = false;
    }

    boolean containsChar(char ch){
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    Node get(char ch){
        return links[ch - 'a'];
    }

    void setEnd(){
        endFlag = true;
    }

    boolean isEnd(){
        return endFlag;
    }
}