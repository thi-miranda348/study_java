package day05;

import java.util.Scanner;

public class SimpleBankingApp {
    public static void main(String[] args) {
        String[] userNames = {"admin", "user", "student"};
        double[] balances = {5000.0, 100.0, 25.5};


        Scanner scanner = new Scanner(System.in);
        System.out.println("--- WELCOME TO THE BANK ---");

        System.out.print("Enter the username: ");
        String inputName = scanner.nextLine();


        boolean isFound = false;
        for (int i=0; i < userNames.length; i++) {
            if (inputName.equals(userNames[i])) {
                isFound = true;
                System.out.println("Welcome, " + userNames[i] +"! Current Balance: $" + balances[i]);


                while(true) {
                    showMenu();
                    System.out.print("Select: ");
                    int menuInput = scanner.nextInt();

                    if (menuInput == 1) {
                        System.out.print("Enter amount: ");

                        double withdrawMoney = scanner.nextDouble();

                        if (withdrawMoney <= balances[i]) {
                            balances[i] -= withdrawMoney;
                            System.out.println("Success! New Balance: $" + balances[i]);
                        } else {
                            System.out.println("Error: Insufficient funds!");
                        }
                    } else if (menuInput == 2) {
                        System.out.print("Enter amount: ");

                        double depositMoney = scanner.nextDouble();

                        if (depositMoney >= 0) {
                            balances[i] += depositMoney;
                            System.out.println("Success! New Balance: $" + balances[i]);
                        } else {
                            System.out.println("Invalid number. Please try again");
                        }
                    } else if (menuInput == 3) {
                        System.out.println("Goodbye!");
                        break;
                    } else {
                        System.out.println("Invalid option.");
                    }
                }
                break;
            }
            } if (!isFound) {
                System.out.println("Log in failed. Please try again");

            }


        scanner.close();

    }

    public static void showMenu() {
        System.out.println("\n --- MENU ----");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Exit");

    }


}
