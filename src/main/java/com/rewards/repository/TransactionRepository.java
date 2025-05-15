package com.rewards.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rewards.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
}
