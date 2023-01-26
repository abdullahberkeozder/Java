import java.util.Scanner;

public class circle_area_and_radius_calculator {
    public static void main(String[] args){
        double pi = 3.14, radius;
        int angle;

        Scanner imp = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        radius = imp.nextDouble();
        System.out.print("Enter angle of circle: ");
        angle = imp.nextInt();

        double radius_of_circle = 2 * pi * radius;
        double area_of_circle = pi * radius * radius;
        double angle_area_of_circle = (pi * (radius * radius) * angle ) / 360;

        System.out.println("radius of circle: " + radius_of_circle);
        System.out.print("area of circle: " + area_of_circle);
        System.out.print("Angle area of circle: " + angle_area_of_circle);

    }

}
