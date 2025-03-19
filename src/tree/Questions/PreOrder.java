import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// Problem Statement: Given the root of a Binary Tree, write a function that returns an array containing the preorder traversal of the tree using an iterative approach with a stack.
//https://takeuforward.org/data-structure/iterative-preorder-traversal-of-binary-tree


public class PreOrder {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        bt.populated(sc);
        System.out.println(preOrderTraversal(bt.root));
    }

    static List<Integer> preOrderTraversal(Node root){
        Node node = root;
        List<Integer> preorder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(node != null) {
            preorder.add(node.data);
            if(node.left != null){
                if(node.right != null){
                    stack.push(node.right);
                }   
                node = node.left;
            }
            else if(node.right != null){
                node = node.right;
            }
            else{
                if(!stack.isEmpty()){
                    node = stack.pop();
                }
                else{
                    break;
                }
            }
        }
        return preorder;
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
