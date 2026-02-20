package com.bankingapp.service;

import com.bankingapp.exception.BankingException;
import com.bankingapp.model.Account;
import com.bankingapp.repository.AccountRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class BankingService {
    private final AccountRepository repo;
    private Account loggedInAccount;

    public BankingService() {
        this.repo = new AccountRepository();
        this.loggedInAccount = null;
    }


    public boolean login(String accountNumber, String pin) throws BankingException {
        Account acc = repo.findAccount(accountNumber);
        if (acc == null) {
            throw new BankingException("Account not found!");
        }
        if (!acc.validatePin(pin)) {
            throw new BankingException("Incorrect PIN!");
        }
        this.loggedInAccount = acc;
        logTransaction("LOGIN", 0);
        return true;
    }

    public void logout() {
        this.loggedInAccount = null;
    }

    public boolean isLoggedIn() {
        return this.loggedInAccount != null;
    }

    public double checkBalance() {
        return loggedInAccount.getBalance();
    }

    public void deposit(double amount) {
        loggedInAccount.deposit(amount);
        logTransaction("DEPOSIT", amount);
    }

    public void withdraw(double amount) throws BankingException {
        loggedInAccount.withdraw(amount);
        logTransaction("WITHDRAW", amount);
    }


    private void logTransaction(String type, double amount) {
        try (FileWriter writer = new FileWriter("transactions.txt", true)) {
            String time = LocalDateTime.now().toString();
            String log = String.format("[%s] ACC: %s | TYPE: %s | AMOUNT: $%.2f | BALANCE: $%.2f\n",
                    time, loggedInAccount.getAccountNumber(), type, amount, loggedInAccount.getBalance());
            writer.write(log);
        } catch (IOException e) {
            System.out.println("⚠️ Warning: Could not write receipt to file.");
        }
    }
}