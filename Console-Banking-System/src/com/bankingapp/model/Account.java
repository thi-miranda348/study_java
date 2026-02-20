package com.bankingapp.model;

import com.bankingapp.exception.BankingException;

public abstract class Account {
    private final String accountNumber;
    private final String pin;
    protected double balance;

    public Account(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }


    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }


    public abstract void withdraw(double amount) throws BankingException;
}