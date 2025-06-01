package com.mikrofinans.MikroFinans.controller;

import com.mikrofinans.MikroFinans.model.Transaction;
import com.mikrofinans.MikroFinans.model.request.TransactionsDTO;
import com.mikrofinans.MikroFinans.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    //Gelir-Gider ekleme
    @PostMapping("/add")
    public Transaction addTransaction(@Valid @RequestBody TransactionsDTO dto) {
        return transactionService.addTransaction(dto);
    }

    //Tüm Gelir-Gider listeleme
    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    //Id göre listeleme
    @GetMapping("/{id}")
    public Optional<Transaction> getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    //Gelir-Gider silme
    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
