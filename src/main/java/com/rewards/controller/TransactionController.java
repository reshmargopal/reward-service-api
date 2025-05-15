package com.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.model.Transaction;
import com.rewards.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/{customerId}")
    public Transaction createTransaction(@PathVariable Long customerId,
                                         @RequestBody Transaction transaction) {
        return transactionService.saveTransaction(customerId, transaction);
    }

}
	
