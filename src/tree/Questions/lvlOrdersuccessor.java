// package tree.Questions;

// https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class lvlOrdersuccessor extends Exception {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        bt.populated(sc);
        try {
            int successor = lvlordersuc(bt.root, 5);
            if (successor != Integer.MIN_VALUE) {
                System.out.println("Level Order Successor: " + successor);
            } else {
                System.out.println("No successor found for the target.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static int lvlordersuc(Node root,int target) throws Exception{
        if (root == null) {
            throw new Exception("Tree is Empty");
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            if (node.data == target) {
                if (!queue.isEmpty()) {
                    return queue.poll().data;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        throw new Exception("Target is not in the Tree");
    }

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    static class BinaryTree{

        public Node root;
    
        public BinaryTree(){
            root = null;
        }
    
        public void populated(Scanner scanner){
            System.out.print("Enter the root Node: ");
            int value = scanner.nextInt();
            root = new Node(value);
            populated(scanner,root);
        }
    
        private void populated(Scanner scanner,Node node){
            System.out.print("Do you want to insert to left of "+ node.data + ": ");
            boolean left = scanner.nextBoolean();
            if(left){
                System.out.print("Enter the left node value :" );
                int val = scanner.nextInt();
                node.left = new Node(val);
                populated(scanner,node.left);
            }
            System.out.print("Do you want to insert to right of "+ node.data + ": ");
            boolean right = scanner.nextBoolean();
            if(right){
                System.out.print("Enter the right node value : ");
                int val = scanner.nextInt();
                node.right = new Node(val);
                populated(scanner,node.right);
            }
        }
    
        public void display(){
            show(this.root);
        }
    
        private void show(Node root){
            if(root == null){
                System.out.println("Empty tree");
                return;
            }
            System.out.print(root.data + " ");
            if(root.left != null){
                show(root.left);
            }
            if(root.right != null){
                show(root.right);
            }
        }
    }
}
