package com.mikrofinans.MikroFinans.service;

import com.mikrofinans.MikroFinans.model.Transaction;
import com.mikrofinans.MikroFinans.model.User;
import com.mikrofinans.MikroFinans.model.Category;
import com.mikrofinans.MikroFinans.model.request.TransactionsDTO;
import com.mikrofinans.MikroFinans.repository.TransactionRepository;
import com.mikrofinans.MikroFinans.repository.UserRepository;
import com.mikrofinans.MikroFinans.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository,
                              UserRepository userRepository,
                              CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    // Gelir-Gider ekleme
    public Transaction addTransaction(TransactionsDTO dto) {

        //Id var mı kontrol
        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        Optional<Category> optionalCategory = categoryRepository.findById(dto.getCategoryId());

        User user = optionalUser.get();
        Category category = optionalCategory.get();

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setCategory(category);
        transaction.setAmount(dto.getAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setDate(dto.getDate());
        transaction.setIsIncome(dto.getIsIncome());

        return transactionRepository.save(transaction);
    }


    //Gelir-Gider listeleme
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    //Id göre listeleme
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    //İşlem silme
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
