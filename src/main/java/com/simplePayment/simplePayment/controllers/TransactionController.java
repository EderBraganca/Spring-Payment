package com.simplePayment.simplePayment.controllers;

import com.simplePayment.simplePayment.domain.transaction.Transaction;
import com.simplePayment.simplePayment.dtos.TransactionDTO;
import com.simplePayment.simplePayment.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transaction newTransaction = this.transactionService.createTransaction(transaction);
        return ResponseEntity.ok().body(newTransaction);
    }
}
