package com.bankingapp;

import com.bankingapp.exception.BankingException;
import com.bankingapp.service.BankingService;

import java.util.Scanner;

public class ATMApplication {
    public static void main(String[] args) {
        BankingService bankService = new BankingService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println(" 🏦 WELCOME TO SECURE BANK ATM SYSTEM ");
        System.out.println("==========================================");


        while (true) {
            if (!bankService.isLoggedIn()) {
                System.out.println("\n--- PLEASE LOG IN ---");
                System.out.print("Enter Account Number: ");
                String accNum = scanner.nextLine();
                System.out.print("Enter PIN: ");
                String pin = scanner.nextLine();

                try {
                    bankService.login(accNum, pin);
                    System.out.println("✅ Login Successful!");
                } catch (BankingException e) {
                    System.out.println("❌ " + e.getMessage());
                    continue;
                }
            }


            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. 💵 Check Balance");
            System.out.println("2. 📥 Deposit Funds");
            System.out.println("3. 📤 Withdraw Funds");
            System.out.println("0. 🚪 Log Out");

            System.out.print("👉 Choose option: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.printf("Current Balance: $%.2f\n", bankService.checkBalance());
                        break;
                    case "2":
                        System.out.print("Enter amount to deposit: $");
                        double depAmount = Double.parseDouble(scanner.nextLine());
                        bankService.deposit(depAmount);
                        System.out.println("✅ Deposit successful!");
                        break;
                    case "3":
                        System.out.print("Enter amount to withdraw: $");
                        double withAmount = Double.parseDouble(scanner.nextLine());
                        bankService.withdraw(withAmount);
                        System.out.println("✅ Please take your cash.");
                        break;
                    case "0":
                        bankService.logout();
                        System.out.println("👋 Logged out securely. Thank you!");
                        break;
                    default:
                        System.out.println("❌ Invalid choice.");
                }
            } catch (BankingException e) {
                System.out.println("🚫 TRANSACTION FAILED: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid number format. Please enter digits.");
            }
        }
    }
}