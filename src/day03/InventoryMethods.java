package day03;
// The Store Manager finds it annoying to restart the application every time they want to add a product. The system needs a Main Menu loop. Also, the Tech Lead (me) reviewed your code and said the main method is too messy. You must refactor the logic into separate Methods.
import java.util.Scanner;


public class InventoryMethods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Main Menu Loop
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add new product");
            System.out.println("2. Exit");
            System.out.println("Select: ");

            int userOption = input.nextInt();

            // Handle Exit
            if (userOption == 2) {
                System.out.println("Goodbye!");
                break;
            }
            // Handle Add Product
            if (userOption == 1) {
                printSeparator(18);

                System.out.print("Enter Price: ");
                double price = input.nextDouble();

                System.out.print("Enter Category Code (1-3): ");
                int code = input.nextInt();

                String categoryName = getCategoryName(code);

                printSeparator(30, "*");
                System.out.println("Category: " + categoryName);
                System.out.println("Price: $" + price);
                printSeparator(30, "*");
            }

        }
        input.close();
    }

    // METHODS
    // Method 1: Logic only. No Scanner inside here.
    public static String getCategoryName(int code) {
        return switch (code) {
            case 1 -> "Electronics";
            case 2 -> "Apparel";
            case 3 -> "Kitchen";
            default -> "General";
        };

    }


    // Method 2: Standard separator
    public static void printSeparator(int length) {
        for (int i = 1; i <= length; i++) {
            System.out.print("-");
        }
        System.out.println(); // Go to next line after loop finishes
    }

    // Method 3: Overloaded separator (Custom character)
    public static void printSeparator(int length, String symbol) {
        for (int i = 1; i <= length; i++) {
            System.out.print(symbol);
        }
        System.out.println();

    }
}