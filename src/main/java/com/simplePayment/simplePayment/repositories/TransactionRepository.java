package com.simplePayment.simplePayment.repositories;

import com.simplePayment.simplePayment.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
