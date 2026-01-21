package day02;
// The Store Manager complained that the V1 system allows invalid data (like negative prices) and lacks categorization. We need to upgrade the system to handle logic decisions.
import java.util.Scanner;


public class InventoryLogic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input Validation (If)
        System.out.print("Enter Buying Price: ");
        double buyingPrice = input.nextDouble();

        if (buyingPrice <0) {
            System.out.println("Error: Invalid Price!");
            buyingPrice = 0;
        }


        // Category Selection (Switch)
        System.out.print("Enter The Number of Category Code (1: Electronics; 2: Apparel; 3: Kitchen): ");
        int categoryCode = input.nextInt();


        // Old version
//        String categoryName;
//        switch (categoryCode) {
//            case 1:
//                categoryName = "Electronics";
//                break;
//            case 2:
//                categoryName = "Apparel";
//                break;
//            case 3:
//                categoryName = "Kitchen";
//                break;
//            default: categoryName = "General";
//        }
        // Modern switch
        String categoryName = switch (categoryCode) {
            case 1 -> "Electronics";
            case 2 -> "Apparel";
            case 3 -> "Kitchen";
            default -> "General";
        };


        // Stock Status (Ternary)
        System.out.print("Enter Quantity: ");
        int quantity = input.nextInt();

        // The "Scanner Bug" - Consume the leftover newline
        input.nextLine();
        String status = (quantity >50) ? "High Stock" : "Normal Stock";

        System.out.print("Type CONFIRM to save: ");
        String save = input.nextLine();

        if (save.equals("CONFIRM")) {
            System.out.println("--- REGISTERED PRODUCT ---");
            System.out.println("Category: " + categoryName);
            System.out.println("Status: " + status);
            System.out.println("Price: $" + buyingPrice);
        } else System.out.println("Action Cancelled.");


        input.close();
    }



}
