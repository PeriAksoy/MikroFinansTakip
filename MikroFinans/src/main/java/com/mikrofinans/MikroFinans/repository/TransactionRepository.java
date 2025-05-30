package com.mikrofinans.MikroFinans.repository;

import com.mikrofinans.MikroFinans.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
