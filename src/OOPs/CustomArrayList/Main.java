public class Main {
    public static void main(String[] args) {
        customAL arr = new customAL();
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.remove();
        System.out.println(arr.size());
        arr.display();
        // Why to use Generic ?
        // For the type security like defining the type that ArrayList should contain. Like only one Type at once.
        customgenericAL<Integer> arr2 = new customgenericAL<>();
        arr2.add(20);
        arr2.add(90);
        arr2.add(30);
        arr2.add(40);
        arr2.display();
        arr2.remove();
        arr2.display();
    }
}