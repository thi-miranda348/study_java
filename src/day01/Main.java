package day01;
// The user (Store Manager) needs to input product details manually, and the system should display a summary report with calculated values.
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Initialize Scanner
        Scanner input = new Scanner(System.in);

        // Input String
        System.out.print("Enter Product Name: ");
        String productName = input.nextLine();


        // Input Double
        System.out.print("Enter Buying Price: ");
        double buyingPrice = input.nextDouble();

        // Input Int
        System.out.print("Enter Quantity: ");
        int quantity = input.nextInt();


        // Calculations
        double totalValue = buyingPrice * quantity;
        // Explicit Casting - cast the result of the multiplication to (int) to chop off decimals
        int promoPrice = (int) (buyingPrice * 0.5);


        // Output
        System.out.println("... PROCESSING ...");
        System.out.println("--- PRODUCT REPORT ---");
        System.out.println("Item Name: " +  productName );
        System.out.println("Total Stock Value: $" + totalValue );
        System.out.println("Clearance Price (Int): $" + promoPrice);


        // Close the correct variable name "input"
        input.close();
    }
}