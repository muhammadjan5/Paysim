package com.mfsys.paysim.controller;

import com.mfsys.paysim.service.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")

public class TransactionController {

    private final Transaction transactionService;

    public TransactionController(Transaction transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit/{username}/{amount}")
    public ResponseEntity<com.mfsys.paysim.model.Transaction> deposit(
            @PathVariable String username,
            @PathVariable double amount) {

        return ResponseEntity.status(202)
                .body(transactionService.deposit(username, amount));
    }
}
