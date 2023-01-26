import java.util.Scanner;

public class shoppingCalculator {
    public static void main(String[] aStrings){
        int pear, apple, tomato, banana, aubergine;
        double price;

        Scanner inp = new Scanner(System.in);
        System.out.print("How Many Kilos of Pear? : ");
        pear = inp.nextInt();
        System.out.print("How Many Kilos of Apple? : ");
        apple = inp.nextInt();
        System.out.print("How Many Kilos of Tomato? : ");
        tomato = inp.nextInt();
        System.out.print("How Many Kilos of Banana? : ");
        banana = inp.nextInt();
        System.out.print("How Many Kilos of Aubergine? : ");
        aubergine = inp.nextInt();

        price = pear * 2.14 + apple * 3.67 + tomato * 1.11 + banana * 0.95 + aubergine * 5.00;

        System.out.print("Total Price: " + price + " TL");
    }
}
