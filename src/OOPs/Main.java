// package OOPs;
public class Main {
    public static void main(String[] args) {
        // Students details = new Students(3,"Ram",87.4f);
        // System.out.println(details.marks);
        // System.out.println(details.name);
        // System.out.println(details.rollno);
        // details.printname();
        // details.printrollno();
        // details.printmarks();
        // details.printall();
        // Students random = new Students();
        // random.printall();
        // Integer a = new Integer(100);
        // System.out.println(a);

        // Human h =  new Human(20, "Aditya", 100, false,"Male");
        // Human h1 =  new Human(22, "Rahul", 10000, false,"Male");
        // Human.humanpopulation();
        // singleton obj = singleton.getinstance();
        // System.out.println(obj);

        CLL cll = new CLL();
        cll.add(10);
        cll.add(20);
        cll.add(30);
        cll.add(40);
        cll.add(50);
        cll.add(0,0);
        cll.display();
        System.out.println(cll.size());
        cll.remove();
        cll.remove();
        cll.display();
        System.out.println(cll.size());
    }
}

class Students {
    int rollno;
    String name;
    float marks;

    Students(){
        this(0,null,0.0f);
    }

    Students(int rollno,String name , float marks){
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    void printname(){
        System.out.println(this.name);
    }

    void printrollno(){
        System.out.println(this.rollno);
    }

    void printmarks(){
        System.out.println(this.marks);
    }

    void printall(){
        System.out.println(this.name);
        System.out.println(this.rollno);
        System.out.println(this.marks);
    }

    // @Override
    // protected void finalize() throws Throwable{
    //     System.out.println("Object is destroyed");
    // }
}