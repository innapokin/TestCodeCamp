import java.util.*;
import java.lang.*;
public class Main {

    public static void main(String[] args) {
        double x, y, z;
        Scanner sc = new Scanner(System.in);
        System.out.println("Pythagoras Theorem");
        System.out.println("What is Adjacent?");
        x = sc.nextInt();
        System.out.println("What is Opposite?");
        y = sc.nextInt();
        z = Math.sqrt((x * x) + (y * y));
        System.out.println("The Hypotenuse is " + z);
    }
}