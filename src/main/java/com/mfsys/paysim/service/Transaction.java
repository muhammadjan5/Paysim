package com.mfsys.paysim.service;

public interface Transaction {
    com.mfsys.paysim.model.Transaction deposit(String username, double amount);
}
