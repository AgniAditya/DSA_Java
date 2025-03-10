public class Inheritance {
    static class Animal{
        String name;
        Animal(){
            System.out.println("Animal");
        }
        Animal(String name){
            this.name = name;
        }
    }
    static class Dog extends Animal{
        Dog(String name){
            super(name);
            System.out.println(name);
        }
    }
    public static void main(String[] args) {
        Dog obj = new Dog("German Shepard");
        A b = new B();
        b.Ab();
        A.greeting();;
    }
}

interface A{
    public void Ab();
    static void greeting(){
        System.out.println("Hey ....");
    }
}

class B implements A{
    @Override
    public void Ab() {
        System.out.println("Hey");
    }
}