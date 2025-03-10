// package OOPs;
public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    String sex;
    /*
     * The static keyword same for all instance(Object) of class.
     * Static variable or methods are belong to the class not the objects.
     */
    static long population;
    public Human(int age,String name,int salary,boolean married,String sex){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        this.sex = sex;
        Human.population += 1;
    }
    void printall(){
        System.out.println(this.age);
        System.out.println(this.name);
        System.out.println(this.salary);
        System.out.println(this.married);
        System.out.println(this.sex);
        System.out.println(Human.population);
    }
    static void humanpopulation(){
        System.out.println(Human.population);
    }
}