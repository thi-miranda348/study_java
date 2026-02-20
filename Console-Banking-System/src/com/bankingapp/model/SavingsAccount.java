package com.bankingapp.model;

import com.bankingapp.exception.BankingException;

public class SavingsAccount extends Account {
    private final double MINIMUM_BALANCE = 50.0;

    public SavingsAccount(String accountNumber, String pin, double initialBalance) {
        super(accountNumber, pin, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdrawal amount must be positive.");
        }
        if (this.balance - amount < MINIMUM_BALANCE) {
            throw new BankingException("Insufficient funds. You must leave at least $" + MINIMUM_BALANCE + " in your account.");
        }
        this.balance -= amount;
    }
}