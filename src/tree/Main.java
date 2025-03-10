public class Main {
    public static void main(String[] args) throws Exception {
        // BinaryTree tree = new BinaryTree();
        // Scanner sc = new Scanner(System.in);
        // tree.populated(sc);
        // tree.display();
        // BST bst = new BST();
        // bst.insert(15);
        // bst.insert(10);
        // bst.insert(20);
        // bst.insert(8);
        // bst.insert(12);
        // bst.insert(1);
        // bst.display();
        // System.out.println(bst.search(0));
        // System.out.println(bst.balanced());

        // AVL tree = new AVL();
        // for(int i = 0; i < 7; i++){
        //     tree.insert(i);
        // }
        // System.out.println(tree.height());
        // System.out.println(tree.balanced());
        // tree.display();

        int[] arr = {9,-8};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
        System.out.println(tree.query(1,1));
        tree.update(0, 3);
        tree.display();
        System.out.println(tree.query(1,1));
    }
}