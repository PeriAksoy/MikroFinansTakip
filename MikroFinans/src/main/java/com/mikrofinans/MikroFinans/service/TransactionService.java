package com.mikrofinans.MikroFinans.service;

import com.mikrofinans.MikroFinans.model.Transaction;
import com.mikrofinans.MikroFinans.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    //Gelir-Gider ekleme
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    //Gelir-Gider listeleme
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    //İşlem no'ya göre listeleme
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }
    //İşlem silme
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
