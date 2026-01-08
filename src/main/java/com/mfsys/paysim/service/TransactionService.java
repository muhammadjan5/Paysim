package com.mfsys.paysim.service;

import com.mfsys.paysim.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class TransactionService implements Transaction {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public com.mfsys.paysim.model.Transaction deposit(String username, double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        com.mfsys.paysim.model.Transaction tx = new com.mfsys.paysim.model.Transaction();
        tx.setUsername(username);
        tx.setAmount(amount);
        tx.setTimestamp(LocalDateTime.now());
        return repository.save(tx);
    }


}
