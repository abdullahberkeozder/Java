import java.util.Scanner;

public class kdvCalculator {
    public static void main(String[] aStrings){
        int withKDV;
        int price;

        Scanner inp = new Scanner(System.in);
        System.out.print("Enter price of item: ");
        price = inp.nextInt();

        if(price == 1000 || price > 1000){
            withKDV = price + (price * 8) / 100;

        }
        else
            withKDV = price + (price * 18) / 100;

        System.out.println("The pric of item with KDV " + withKDV);
    }
}
