public class Main {
    public static void main(String[] args) {
        // CLL cll = new CLL();
        // cll.add(10);
        // cll.display();
        // cll.add(20);
        // cll.add(30);
        // cll.add(40);
        // cll.add(50);
        // cll.add(0,0);
        // System.out.println(cll.size());
        // cll.remove();
        // cll.remove();
        // cll.display();
        // System.out.println(cll.size());

        LL l1=new LL();
        // l1.insertFirst(1);
        // l1.insertFirst(20);
        // l1.insertFirst(0);
        l1.insert(2);
        l1.insert(4);
        l1.insert(60);
        l1.insert(34);
        // l1.insert(1, 33);
        l1.display();
        l1.insertrec(19);
        l1.insertrec(9);
        l1.insertatrec(1,9);
        // System.out.println(l1.delete(3));
        l1.display();
        // System.out.println(l1.deleteLast());
        // System.out.println(l1.deleteLast());
        // l1.display();
    }
}
