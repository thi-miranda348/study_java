package com.bankingapp.repository;

import com.bankingapp.model.Account;
import com.bankingapp.model.SavingsAccount;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    private final Map<String, Account> database;

    public AccountRepository() {
        database = new HashMap<>();
        database.put("1111", new SavingsAccount("1111", "1234", 500.0));
        database.put("2222", new SavingsAccount("2222", "9999", 1000.0));
    }

    public Account findAccount(String accountNumber) {
        return database.get(accountNumber);
    }
}