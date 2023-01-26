import java.util.Scanner;

public class bmiCalculator {
    public static void main(String[] args){
        double length, weight, bmi;

        Scanner imp = new Scanner(System.in);
        System.out.print("Enter your length: ");
        length = imp.nextDouble();
        System.out.print("Enter your weight: ");
        weight = imp.nextDouble();

        bmi = weight / length * length;

        System.out.print("Your BMI : " + bmi);
    }
}
