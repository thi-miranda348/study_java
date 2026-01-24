package day04;
// We need to store up to 5 products in memory. The Store Manager also needs a way to Search for a product to see if we have it in stock.
import java.util.Scanner;

public class InventoryArrays {
    public static void main(String[] args) {
        // Initialize Fixed Arrays (Size 5)
        String[] productNames = new String[5];
        double[] productPrices = new double[5];


        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add Product");
            System.out.println("2. View All");
            System.out.println("3. Search Product");
            System.out.println("4. Exit");
            System.out.print("Your selection: ");

            int userOption = input.nextInt();
            input.nextLine();


            if (userOption == 1) {
                // --- ADD PRODUCT LOGIC ---
                System.out.print("Enter Name: ");
                String inputName = input.nextLine();

                System.out.print("Enter Price: ");
                double inputPrice = input.nextDouble();

                boolean isAdded = false;

                for (int i = 0; i < productNames.length; i++) {
                    if (productNames[i] == null) {
                        productNames[i] = inputName;
                        productPrices[i] = inputPrice;
                        System.out.println("Success: Product added to Slot " + i);

                        isAdded = true;
                        break;
                    }
                }

                if (!isAdded) {
                    System.out.println("Error: Inventory is FULL!");
                }

            } else if (userOption == 2) {
                // --- VIEW ALL LOGIC ---
                System.out.println("--- CURRENT INVENTORY ---");
                for (int i = 0; i < productNames.length; i++) {
                    if (productNames[i] != null) {
                        System.out.println("Slot " + i + ": " + productNames[i] + " - $" + productPrices[i]);

                    }

                }
            } else if (userOption == 3) {
                // --- SEARCH LOGIC ---
                System.out.println(" Search Keyword: ");
                String keyword = input.nextLine();
                boolean isFound = false;

                for (int i = 0; i < productNames.length; i++) {
                    if (productNames[i] != null && productNames[i].equalsIgnoreCase(keyword)) {
                        System.out.println("FOUND! " + productNames[i] + " costs $" + productPrices[i]);
                        isFound = true;
                    }

                }
                if (!isFound) {
                    System.out.println("Product not found.");

                }


            } else if (userOption == 4) {
                System.out.println("Goodbye!");
                break;

        } else {System.out.println("Invalid option.Try again");}
    }
        input.close();
    }

}
