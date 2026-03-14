import java.util.*;

public class A_VanyaAndCubes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cubes = sc.nextInt();
        int i = 1;
        while (true) {
            int levelCubes = (i * (i + 1)) / 2;
            if(levelCubes > cubes) break;
            cubes -= levelCubes;
            i++;
        }
        System.out.println(i-1);
    }
}
