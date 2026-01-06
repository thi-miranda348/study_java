package day02;
import java.util.Scanner;

public class BankingMenu {
    public static void main(String[] args) {
        Scanner scanner = new java.util.Scanner(System.in);
        int choice;

        while(true) {
            System.out.println("=== BANKING SYSTEM ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("-> Logic for Check Balance (Coming soon)");
                    break;
                case 2:
                    System.out.println("-> Logic for Withdraw (Coming soon)");
                    break;
                case 3:
                    System.out.println("-> Logic for Deposit (Coming soon)");
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        }


    }
}
