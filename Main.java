import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int math, phys, eng, music, chem;

        Scanner inp = new Scanner(System.in);

        System.out.print("Enter math Exam: ");
        math = inp.nextInt();
        System.out.print("Enter phys Exam: ");
        phys = inp.nextInt();
        System.out.print("Enter eng Exam: ");
        eng = inp.nextInt();
        System.out.print("Enter music Exam: ");
        music = inp.nextInt();
        System.out.print("Enter chem Exam: ");
        chem = inp.nextInt();

        double total = (math + phys + eng + music + chem);
        double avarage = total / 5;

        String result = avarage > 60 ? "pass" : "not pass";
        System.out.println("Your Avarage Exam Note: " + avarage + " => " + result);
    }
}