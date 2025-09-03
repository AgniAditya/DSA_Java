package CodeForces;
import java.util.*;
public class A_AntonAndPolyhedrons {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfPolyhedrons = sc.nextInt();
            int totalPolyhedronsFaces = 0;

            while (numOfPolyhedrons-- > 0) {
                String polyhedron = sc.next();
                if(polyhedron.equals("Tetrahedron")) totalPolyhedronsFaces += 4;
                else if(polyhedron.equals("Cube")) totalPolyhedronsFaces += 6;
                else if(polyhedron.equals("Octahedron")) totalPolyhedronsFaces += 8;
                else if(polyhedron.equals("Dodecahedron")) totalPolyhedronsFaces += 12;
                else if(polyhedron.equals("Icosahedron")) totalPolyhedronsFaces += 20;
            }
            System.out.println(totalPolyhedronsFaces);
        }
    }
}
