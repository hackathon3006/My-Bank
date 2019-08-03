package com.mybank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.bank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{

}
