import java.util.Scanner;

public class areaCalculator{
    public static void main(String[] args){
        int a, b;
        double c;


        Scanner imp = new Scanner(System.in);
        System.out.print("1st value of triangle: ");
        a = imp.nextInt();
        System.out.print("2nd value of triangle: ");
        b = imp.nextInt();
        System.out.print("hypotenuse value of triangle: ");
        c = imp.nextDouble();

        double radius = a + b + c;
        double area = radius/2 * (radius/2 - a) * (radius/2 - b) * (radius/2 - c);
        area = Math.sqrt(area);

        System.out.println("radius of triangle: " + radius);
        System.out.print("area of triangle: " + area);
    }
}