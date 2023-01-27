import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {


        int n1, n2, select;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        n1 = input.nextInt();

        System.out.print("Enter second number: ");
        n2 = input.nextInt();

        System.out.println("1-Addition\n2-Substraction\n3-Multiplication\n4-Division");
        System.out.print("Choose: ");
        select = input.nextInt();

        switch (select) {
            case 1:
                System.out.println("Addition: " + (n1 + n2));
                break;
            case 2:
                System.out.println("Substraction: " + (n1 - n2));
            case 3:
                System.out.println("Multiplication: " + (n1 * n2));
            case 4:
                System.out.println("Division: " + (n1 / n2));
            default:
                System.out.println("You made a selection error. Try again.");
                break;
        }
    }
}



